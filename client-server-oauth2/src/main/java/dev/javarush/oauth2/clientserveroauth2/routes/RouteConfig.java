package dev.javarush.oauth2.clientserveroauth2.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        r -> r
                                .path("/resource/**")
                                .filters(
                                        f -> f
                                                .rewritePath("/resource/", "/")
                                                .tokenRelay()
                                )
                                .uri("http://localhost:8082")
                )
                .build();
    }
}
