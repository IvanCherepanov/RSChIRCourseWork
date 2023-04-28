package com.example.rschircoursework.security.fourthsemversion;

import com.example.rschircoursework.model.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3006")
public class AuthJWTController {
    private final AuthService authService;

    public AuthJWTController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> signUpUser(@Valid @RequestBody AuthRequest signUpRequest) {
        User user = authService.signUp(signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getName());
        Map<?, ?> data = Map.of("user", user, "success", true);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("user logged")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(data)
                        .build());
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> signInUser(@Valid @RequestBody AuthRequest signInRequest) {
        User user = authService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        Map<?, ?> data = Map.of("user", user, "success", true);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("user logged")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(data)
                        .build());
    }
}
