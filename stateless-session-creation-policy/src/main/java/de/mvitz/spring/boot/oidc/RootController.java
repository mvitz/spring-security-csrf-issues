package de.mvitz.spring.boot.oidc;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping
    public Authentication root(Authentication authentication) {
        return authentication;
    }
}
