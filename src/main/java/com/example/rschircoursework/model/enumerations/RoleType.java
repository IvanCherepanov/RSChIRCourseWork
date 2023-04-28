package com.example.rschircoursework.model.enumerations;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public enum RoleType {
    ADMIN,
    USER;

    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(String.format("ROLE_%s", this.name())));
    }
}
