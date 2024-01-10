package com.manage.spring_crud.services;


import com.manage.spring_crud.model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private List<User> users;

    public AuthService() {
        users = Arrays.asList(
                new User("hrmanager", "hr@123", "HR Manager"),
                new User("level1", "level1@123", "Level 1 Interview Panel"),
                new User("level2", "level2@123", "Level 2 Interview Panel"),
                new User("recruiter", "recruiter@123", "Recruiter")
        );
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}