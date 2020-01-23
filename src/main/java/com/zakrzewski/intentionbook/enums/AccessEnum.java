package com.zakrzewski.intentionbook.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.GrantedAuthority;

public enum AccessEnum implements GrantedAuthority {

    ADMIN("ROLE_ADMIN"),
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

    @Override
    public String getAuthority() {
        return name();
    }
}
