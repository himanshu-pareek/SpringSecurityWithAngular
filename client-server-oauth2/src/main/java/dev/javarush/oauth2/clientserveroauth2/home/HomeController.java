package dev.javarush.oauth2.clientserveroauth2.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String getHome() {
        return "Hello, World!\n";
    }
}
