package com.mkaiho.sample.springmetricsapp.application.controller;

import com.mkaiho.sample.springmetricsapp.application.service.UserService;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UserId;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UserResponse;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UsersResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public UsersResponse users() {
        return userService.getAllUserResponse();
    }

    @GetMapping(path = "/users/{userId}")
    public UserResponse user(@PathVariable("userId") String userId) {
        return this.userService.getUserResponseById(new UserId(userId));
    }
}
