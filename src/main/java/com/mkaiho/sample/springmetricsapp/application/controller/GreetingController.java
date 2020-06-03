package com.mkaiho.sample.springmetricsapp.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping(path = "/")
    public Map greet() {
        return Map.of();
    }
}
