package com.example.halo112_generic.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/helloworld")
    @Secured("ROLE_ADMIN")
    public String index() {
        return "Hello world";
    }
}
