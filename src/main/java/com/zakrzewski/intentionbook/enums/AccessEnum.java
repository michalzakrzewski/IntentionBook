package com.zakrzewski.intentionbook.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum AccessEnum {

    SUPER_USER("Proboszcz"),
    USER_KAPLAN("Kaplan"),
    USER_ZAKRYS("Zakrystianin");

    private String roleDescription;

    AccessEnum(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return roleDescription;
    }
}
