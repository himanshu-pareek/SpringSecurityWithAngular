package dev.javarush.resourceserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/hello")
    @CrossOrigin(origins = "http://localhost:8081")
    public Map<String, String> sayHello() {
        return Map.of("text", "Hello World!");
    }
}
