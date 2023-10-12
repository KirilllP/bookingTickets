package com.booking.app.enums;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum EnumRole {
    ADMIN(EnumSet.of(EnumAuthority.READ, EnumAuthority.CREATE, EnumAuthority.DELETE, EnumAuthority.UPDATE)),
    USER(EnumSet.of(EnumAuthority.READ));

    private final EnumSet<EnumAuthority> authorities;

    EnumRole(EnumSet<EnumAuthority> permissions) {
        this.authorities = permissions;
    }

    public EnumSet<EnumAuthority> getAuthorities() {
        return authorities;
    }
    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities() {
        return getAuthorities().stream().map(authorities -> new SimpleGrantedAuthority(authorities.getAuthority()))
                .collect(Collectors.toSet());
    }

}
