package dev.javarush.oauth2.resourceserveroauth2.controller;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // GET localhost:8082/hello
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("hello")
    public Map<String, String> getHello(
            Authentication authentication
    ) {
        String username = authentication.getName();
        return Collections.singletonMap("get_text", "Hello " + username);
    }

    @PostMapping("hello")
    // @PreAuthorize("#token.tokenAttributes.get('custom_role') == 'Johnn'")
    public Map<String, String> postHello(
            JwtAuthenticationToken token
    ) {
        // System.out.println(token.getTokenAttributes().get("custom_role"));
        return Collections.singletonMap("post_text", "Hello " + token.getName());
    }
}
