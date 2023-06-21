package com.example.springangularfrontendserver.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/user")
    public Principal me(Principal user) {
        return user;
    }

}
