package com.lw.dcsjob.server.web.handler;

import cn.hutool.core.util.ObjUtil;
import com.lw.dcsjob.common.core.annotation.OriginalControllerReturnValue;
import com.lw.dcsjob.common.core.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author lw
 * @create 2025-03-04-21:53
 */
@Slf4j
@ControllerAdvice(basePackages = {"com.lw.dcsjob.server"})
public class GlobalRestfulResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        OriginalControllerReturnValue originalControllerReturnValue = methodParameter.getMethodAnnotation(OriginalControllerReturnValue.class);
        if (ObjUtil.isNull(originalControllerReturnValue)) {
            return body;
        }
        if (body instanceof Result<?>) {
            return body;
        } else {
            return new Result<>("请求成功", body);
        }
    }
}
