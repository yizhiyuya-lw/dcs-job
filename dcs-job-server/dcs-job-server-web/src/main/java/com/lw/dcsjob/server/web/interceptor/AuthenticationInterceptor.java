package com.lw.dcsjob.server.web.interceptor;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lw.dcsjob.common.core.exception.DcsJobAuthenticationException;
import com.lw.dcsjob.common.core.util.JsonUtils;
import com.lw.dcsjob.common.core.util.StreamUtils;
import com.lw.dcsjob.server.web.annotation.LoginRequired;
import com.lw.dcsjob.server.web.annotation.RoleEnum;
import com.lw.dcsjob.server.web.model.request.UserSessionVO;
import com.lw.dcsjob.template.datasource.persistence.mapper.NamespaceMapper;
import com.lw.dcsjob.template.datasource.persistence.mapper.SystemUserMapper;
import com.lw.dcsjob.template.datasource.persistence.mapper.SystemUserPermissionMapper;
import com.lw.dcsjob.template.datasource.persistence.po.Namespace;
import com.lw.dcsjob.template.datasource.persistence.po.SystemUser;
import com.lw.dcsjob.template.datasource.persistence.po.SystemUserPermission;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * 系统登录认证
 * @author lw
 * @create 2025-03-05-21:43
 */
@Configuration
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {
    public static final String AUTHENTICATION = "DCS-JOB-AUTH";
    public static final String NAMESPACE_ID = "DCS-JOB-NAMESPACE-ID";
    private final SystemUserMapper systemUserMapper;
    private final NamespaceMapper namespaceMapper;
    private final SystemUserPermissionMapper systemUserPermissionMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        Method method = handlerMethod.getMethod();
        //检查是否有@LoginRequered注解
        if (!method.isAnnotationPresent(LoginRequired.class)) {
            return true;
        }
        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        if (loginRequired.required()) {
            //从请求头中获取token
            String token = request.getHeader(AUTHENTICATION);
            String namespaceId = request.getHeader(NAMESPACE_ID);

            //执行认证
            if (StrUtil.isBlank(token)) {
                throw new DcsJobAuthenticationException("登录过期，请重新登录");
            }
            if (StrUtil.isBlank(namespaceId)) {
                throw new DcsJobAuthenticationException("{} 命名空间不存在", namespaceId);
            }

            SystemUser systemUser;
            try {
                systemUser = JsonUtils.parseObject(JWT.decode(token).getAudience().get(0), SystemUser.class);
            } catch (JWTDecodeException e) {
                throw new DcsJobAuthenticationException("登录过期，请重新登录");
            }

            systemUser = systemUserMapper.selectById(systemUser.getId());
            if (Objects.isNull(systemUser)) {
                throw new DcsJobAuthenticationException("用户不存在");
            }

            Long count = namespaceMapper.selectCount(new LambdaQueryWrapper<Namespace>().eq(Namespace::getUniqueId, namespaceId));
            Assert.isTrue(count > 0, () -> new DcsJobAuthenticationException("[{}] 命名空间不存在", namespaceId));

            UserSessionVO userSessionVO = new UserSessionVO();
            userSessionVO.setId(systemUser.getId());
            userSessionVO.setUsername(systemUser.getUsername());
            userSessionVO.setRole(systemUser.getRole());
            userSessionVO.setNamespaceId(namespaceId);

            //普通用户才获取权限
            if (userSessionVO.isUser()) {
                List<SystemUserPermission> systemUserPermissions = systemUserPermissionMapper.selectList(
                        new LambdaQueryWrapper<SystemUserPermission>()
                                .select(SystemUserPermission::getGroupName)
                                .eq(SystemUserPermission::getSystemUserId, systemUser.getId())
                                .eq(SystemUserPermission::getNamespaceId, namespaceId));
                List<String> groupNames = StreamUtils.toList(systemUserPermissions, SystemUserPermission::getGroupName);
                Assert.notEmpty(groupNames, () -> new DcsJobAuthenticationException("用户组权限为空"));
                userSessionVO.setGroupNames(groupNames);
            }

            request.setAttribute("currentUser", userSessionVO);

            //验证token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(systemUser.getPassword())).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new DcsJobAuthenticationException("登录过期，请重新登录");
            }

            RoleEnum role = loginRequired.role();
            if (role == RoleEnum.USER) {
                return true;
            }
            if (role == RoleEnum.ADMIN) {
                if (role != RoleEnum.getEnumTypeMap().get(systemUser.getRole())) {
                    throw new DcsJobAuthenticationException("不具备访问权限");
                }
            }
            return true;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
