package com.example.rschircoursework.security.fifthsemversion.service;

import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.security.fifthsemversion.dto.UserRegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findUser(Long id);

    String addNewUser(UserRegisterRequest registerRequest);
}
