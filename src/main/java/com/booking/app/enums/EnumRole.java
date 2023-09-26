package com.booking.app.enums;

import java.util.EnumSet;

public enum EnumRole {
    ADMIN(EnumSet.of(EnumPermission.READ,EnumPermission.CREATE,EnumPermission.DELETE,EnumPermission.UPDATE)),
    USER(EnumSet.of(EnumPermission.READ));

    private final EnumSet<EnumPermission> permissions;

    EnumRole(EnumSet<EnumPermission> permissions) {
        this.permissions = permissions;
    }
}
