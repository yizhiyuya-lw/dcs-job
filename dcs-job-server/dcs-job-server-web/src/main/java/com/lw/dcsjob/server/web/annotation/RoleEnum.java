package com.lw.dcsjob.server.web.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lw
 * @create 2025-03-04-21:44
 */
@AllArgsConstructor
@Getter
public enum RoleEnum {
    /**
     * 普通用户
     */
    USER(1, "user"),
    /**
     * 管理员
     */
    ADMIN(2, "admin")
    ;

    private static final Map<Integer, RoleEnum> ENUM_TYPE_MAP = new HashMap<>();

    static {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            ENUM_TYPE_MAP.put(roleEnum.getRoleId(), roleEnum);
        }
    }

    private final Integer roleId;
    private final String roleName;

    public static Map<Integer, RoleEnum> getEnumTypeMap() {
        return ENUM_TYPE_MAP;
    }

    public static boolean isAdmin(Integer roleId) {
        return ADMIN.getRoleId().equals(roleId);
    }

    public static boolean isUser(Integer roleId) {
        return USER.getRoleId().equals(roleId);
    }
}
