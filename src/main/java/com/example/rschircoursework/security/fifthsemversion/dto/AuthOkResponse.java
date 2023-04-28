package com.example.rschircoursework.security.fifthsemversion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthOkResponse {
    @JsonProperty("authToken")
    private String authToken;
}
