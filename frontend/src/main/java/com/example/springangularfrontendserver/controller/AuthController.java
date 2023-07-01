package com.example.springangularfrontendserver.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/user")
    public Principal me(Principal user) {
        return user;
    }

    @GetMapping("/token")
    public Map<String, String> getToken(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }

}
