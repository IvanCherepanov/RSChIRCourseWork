package com.example.rschircoursework.services;

import com.example.rschircoursework.model.entity.User;
import org.springframework.security.core.Authentication;

public interface IUserService extends IAbstractService<User> {
    void create(String email,String username,String password, String role);
    String getUserRole(Authentication authentication);
    Long getUserId(Authentication authentication);
    User findUserByUsername(String username);
}
