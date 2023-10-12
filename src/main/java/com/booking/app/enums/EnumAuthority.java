package com.booking.app.enums;

import org.springframework.security.core.GrantedAuthority;

public enum EnumAuthority{
    CREATE("user:create"),
    READ("user:read"),
    UPDATE("user:update"),
    DELETE("user:delete");

    private final String authority;
    EnumAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
