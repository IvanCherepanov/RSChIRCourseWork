package com.example.rschircoursework.security.fifthsemversion.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
public class UserRegisterRequest {
    @Email(message = "Email is invalid")
    private String email;

    private String password;

    private String managerToken;

    private String name;
}
