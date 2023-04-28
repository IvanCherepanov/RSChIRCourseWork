package com.example.rschircoursework.security.fifthsemversion.service;

import com.example.rschircoursework.security.fifthsemversion.dto.UserCredentials;

public interface IAuthService {
    String authenticate(UserCredentials userCredentials);
}
