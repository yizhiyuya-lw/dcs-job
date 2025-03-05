package com.lw.dcsjob.server.web.model.request;

import com.lw.dcsjob.server.web.annotation.RoleEnum;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @author lw
 * @create 2025-03-05-22:00
 */
@Data
public final class UserSessionVO {

    private Long id;
    private String username;
    private Integer role;
    private String namespaceId;
    private List<String> groupNames;

    public boolean isAdmin() {
        return Objects.equals(this.role, RoleEnum.ADMIN.getRoleId());
    }

    public boolean isUser() {
        return Objects.equals(this.role, RoleEnum.USER.getRoleId());
    }
}
