package com.example.rschircoursework.security.fourthsemversion;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private String type;
    private Long id;
    private String email;
}
