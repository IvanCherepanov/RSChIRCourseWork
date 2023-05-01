package com.example.rschircoursework.security.fifthsemversion.service;

import com.example.rschircoursework.security.fifthsemversion.JwtTokenUtil;
import com.example.rschircoursework.security.fifthsemversion.dto.UserCredentials;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class AuthentServiceImpl implements IAuthService{
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @Override
    public String authenticate(UserCredentials userCredentials) {
//        System.out.println("AuthServiceImpl");
//        System.out.println(userCredentials.getEmail());
//        System.out.println(userCredentials.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userCredentials.getEmail(), userCredentials.getPassword()));
        } catch (BadCredentialsException ex) {
            System.out.println(ex.getStackTrace());
            log.warn("User with email = {} can't auth", userCredentials.getEmail());
            throw ex;
        }
        UserDetails userDetails = userService.loadUserByUsername(userCredentials.getEmail());
        System.out.println(userCredentials);
        log.info("User with email = {} successfully auth", userCredentials.getEmail());

        return jwtTokenUtil.generateToken(userDetails);
    }
    }

