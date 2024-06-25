package org.example.amazonback.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {
    private Long id;
    private RoleName role;

    @Override
    public String getAuthority() {
        return "ROLE_" + role.name();
    }

    public enum RoleName {
        USER,
        ADMIN
    }
}
