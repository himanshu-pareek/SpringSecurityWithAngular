package dev.javarush.oauth2.clientserveroauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class ClientServerOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientServerOauth2Application.class, args);
	}

}

@RestController
class ClientControllers {
	@GetMapping("demo")
	public Map<String, String> getMessage() {
		return Collections.singletonMap("message", "Hello, world!");
	}
}
