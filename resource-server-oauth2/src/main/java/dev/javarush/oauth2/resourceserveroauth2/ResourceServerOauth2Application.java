package dev.javarush.oauth2.resourceserveroauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ResourceServerOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerOauth2Application.class, args);
	}

}
