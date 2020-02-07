package com.example.springconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/getName")
    public String getName() {
        return user.getName();
    }

}
