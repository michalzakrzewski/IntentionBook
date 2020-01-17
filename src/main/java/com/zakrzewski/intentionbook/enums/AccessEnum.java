package com.zakrzewski.intentionbook.enums;

public enum AccessEnum {

    SUPER_USER("Proboszcz"),
    USER_KAP("Kapłan"),
    USER_ZAKR("Zakrystianin");

    private String roleDescription;

    AccessEnum(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

}
