package org.example.grpc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    @GetMapping("/api/hello")
    public String sayHelloHttp(@RequestParam(defaultValue = "World") String name) {
        return "Hello, " + name + "! This is an HTTP REST response.";
    }
}
