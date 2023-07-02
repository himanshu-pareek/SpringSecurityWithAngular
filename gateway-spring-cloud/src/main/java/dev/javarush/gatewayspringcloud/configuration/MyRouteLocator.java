package dev.javarush.gatewayspringcloud.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteLocator {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p ->
                        p.path("/resource/**")
                                .filters(
                                        f -> f.rewritePath("/resource/", "/")
                                )
                                .uri("http://localhost:8082")
                )
                .route(p ->
                        p.path("/**")
                                .uri("http://localhost:8081")
                )
                .build();
    }
}
