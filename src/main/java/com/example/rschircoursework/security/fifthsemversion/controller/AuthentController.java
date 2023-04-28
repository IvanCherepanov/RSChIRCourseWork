package com.example.rschircoursework.security.fifthsemversion.controller;

import com.example.rschircoursework.controllers.AbstractController;
import com.example.rschircoursework.model.entity.User;
import com.example.rschircoursework.security.fifthsemversion.dto.AuthOkResponse;
import com.example.rschircoursework.security.fifthsemversion.dto.ErrorResponse;
import com.example.rschircoursework.security.fifthsemversion.dto.UserCredentials;
import com.example.rschircoursework.security.fifthsemversion.dto.UserRegisterRequest;
import com.example.rschircoursework.security.fifthsemversion.service.IAuthService;
import com.example.rschircoursework.security.fifthsemversion.service.UserService;
import com.example.rschircoursework.services.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@RestController

public class AuthentController extends AbstractController<User, IUserService> {

    private final IUserService iUserService;
    private final UserService userService;
    private final IAuthService authService;

    @Autowired
    protected AuthentController(IUserService service,
                                IAuthService iAuthService,
                                UserService userService) {
        super(service);
        this.iUserService = service;
        this.authService = iAuthService;
        this.userService = userService;
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
