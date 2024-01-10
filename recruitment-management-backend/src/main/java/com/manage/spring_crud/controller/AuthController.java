package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.User;
import com.manage.spring_crud.services.AuthService;
import com.manage.spring_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    /*
    @GetMapping("/user-role")
    public String getUser() {
        String username = credentials.get("username");
        String password = credentials.get("password");
        User loggedInUser = authService.authenticate(username, password);
        loggedInUser.getRo
    } */



    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        System.out.println("AuthController " + username + " " + password);

        User loggedInUser = authService.authenticate(username, password);

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }



}