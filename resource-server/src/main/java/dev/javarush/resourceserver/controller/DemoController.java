package dev.javarush.resourceserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/hello")
    @CrossOrigin(
            origins = "http://localhost:8081",
            allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"}
    )
    public Map<String, String> sayHello(
            Principal user
    ) {
        System.out.printf("Username - %s\n", user.getName());
        return Map.of("text", "Hello World!");
    }
}
