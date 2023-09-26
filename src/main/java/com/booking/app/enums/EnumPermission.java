package com.booking.app.enums;

public enum EnumPermission {
    CREATE("user:create"),
    READ("user:read"),
    UPDATE("user:update"),
    DELETE("user:delete");

   private final String privilege;
    EnumPermission(String privilege) {
        this.privilege = privilege;
    }


    public String getPrivilege() {
        return privilege;
    }


}
