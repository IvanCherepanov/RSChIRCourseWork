package com.example.rschircoursework.security.fifthsemversion.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCredentials {
    private String email;
    private String password;
}
