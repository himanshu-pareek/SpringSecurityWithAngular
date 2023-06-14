package com.example.springangularfrontendserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringAngularFrontendServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularFrontendServerApplication.class, args);
	}

    @Configuration
    protected static class SecurityConfiguration {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
                .httpBasic(Customizer.withDefaults());
            return http.build();
        }
    }

}
