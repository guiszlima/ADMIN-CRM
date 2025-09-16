package com.guiszlima.crm_admin_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody String entity) {
        // TODO: process POST request
        return entity;
    }

    @PostMapping("/register")
    public String register(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
