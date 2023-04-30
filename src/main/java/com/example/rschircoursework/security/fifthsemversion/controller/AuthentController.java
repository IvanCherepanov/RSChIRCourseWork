package com.example.rschircoursework.security.fifthsemversion.controller;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.security.fifthsemversion.JwtTokenUtil;
import com.example.rschircoursework.security.fifthsemversion.dto.*;
import com.example.rschircoursework.security.fifthsemversion.service.IAuthService;
import com.example.rschircoursework.security.fifthsemversion.service.UserService;
import com.example.rschircoursework.services.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3006")
public class AuthentController extends AbstractController<User, IUserService> {

    private final IUserService iUserService;
    private final UserService userService;
    private final IAuthService authService;
    private final JwtConfig jwtConfig;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    protected AuthentController(IUserService service,
                                IAuthService iAuthService,
                                UserService userService,
                                JwtConfig jwtConfig,
                                JwtTokenUtil jwtTokenUtil) {
        super(service);
        this.iUserService = service;
        this.authService = iAuthService;
        this.userService = userService;
        this.jwtConfig = jwtConfig;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest registerRequest) {
        var result = userService.addNewUser(registerRequest);
        if (result.equals("OK")) {
            return ResponseEntity.ok().build();
        }
        else if (result.equals("NAME")){
            return  ResponseEntity.badRequest().body("NAME");
        }
        else if (result.equals("EMAIL")){
            return  ResponseEntity.badRequest().body("EMAIL");
        }
        else{
            return ResponseEntity.badRequest().body("ERROR");
        }

    }

    @PostMapping("/auth")
    public AuthOkResponse authUser(@RequestBody UserCredentials userCredentials) {
        String authToken = authService.authenticate(userCredentials);
        return AuthOkResponse.builder().authToken(authToken).build();
    }

    @GetMapping("/load_user")
    public User loadUserByUsername(HttpServletRequest request){
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
            return null;
        }
        String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
        String username = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("Username: " + username);
        User user = iUserService.findUserByUsername(username);
        return user;
    }

    void sendResponse(HttpServletResponse response, int status, Exception exception)
            throws IOException {
        log.error("Send error response: status: {}, message: {}", status, exception.getMessage());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse error =
                ErrorResponse.builder().code(status).message(exception.getMessage()).build();
        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(out, error);
        out.flush();
    }
}
