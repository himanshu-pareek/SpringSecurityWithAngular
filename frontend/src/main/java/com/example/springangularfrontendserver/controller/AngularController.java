package com.example.springangularfrontendserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    @GetMapping("/bank")
    public String goToBank() {
        return "forward:/";
    }

    @GetMapping("/login")
    public String goToLogin() {
        return "forward:/";
    }

}
