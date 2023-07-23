package dev.javarush.oauth2.resourceserveroauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import javax.swing.text.DefaultStyledDocument;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Configuration
public class AuthorizationConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(
//            HttpSecurity http
//    ) throws Exception {
//        http.authorizeHttpRequests(
//                authz -> authz
//                        .anyRequest().access(new AuthorizationManager<RequestAuthorizationContext>() {
//                            @Override
//                            public AuthorizationDecision check(
//                                    Supplier<Authentication> authentication,
//                                    RequestAuthorizationContext object
//                            ) {
//                                Set<String> authorities = authentication.get().getAuthorities()
//                                        .stream()
//                                        .map(GrantedAuthority::getAuthority)
//                                        .collect(Collectors.toSet());
//                                System.out.println(authorities);
//                                return new AuthorizationDecision(
//                                        authorities.contains("ROLE_ADMIN")
//                                );
//                            }
//                        })
//        );
//        return http.build();
//    }
}
