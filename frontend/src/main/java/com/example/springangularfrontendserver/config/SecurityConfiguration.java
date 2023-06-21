package com.example.springangularfrontendserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //@formatter:off
        http.authorizeHttpRequests((authz) ->
                authz
                    .requestMatchers("/index.html", "/", "/bank", "/login", "*.js", "*.css", "*"
                        + ".ico").permitAll()
                    .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
        //@formatter:on
        return http.build();
    }
}