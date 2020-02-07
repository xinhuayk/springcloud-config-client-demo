package com.example.springconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RefreshScope
public class User {

    @Value("${name}")
    private String name;

    public String getName() {
        return name;
    }

}
