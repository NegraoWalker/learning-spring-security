package com.walker.learningspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class TestAppController {
    @GetMapping
    public String testRunApp(){
        return "pong!";
    }
}
