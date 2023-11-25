package com.walker.learningspringsecurity.controller;

import com.walker.learningspringsecurity.entity.User;
import com.walker.learningspringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService; //Injeção de dependências via construtor

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }
}
