package com.cinema.system.controllers;

import com.cinema.system.dto.RegistrationDTO;
import com.cinema.system.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody final RegistrationDTO user) {
        if (userService.loginExists(user.getLogin())) {
            return new ResponseEntity<>(Collections.singletonList("Login already exists"),
                    HttpStatus.FORBIDDEN);
        }
        String userPassword = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userPassword);
        user.setPassword(encodedPassword);
        userService.registerAsUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
