package com.mkaiho.sample.springmetricsapp.application.controller;

import com.mkaiho.sample.springmetricsapp.application.service.UserService;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UserId;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UserResponse;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UsersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public Mono<UsersResponse> users() {
        logger.info("Begin UserController#users");
        Mono<UsersResponse> response = this.userService.getAllUser()
                .map((UsersResponse::new))
                .doAfterTerminate(() -> {
                    logger.info("End UserController#users");
                });

        return response;
    }

    @GetMapping(path = "/users/{userId}")
    public Mono<UserResponse> user(@PathVariable("userId") String userId) {
        logger.info("Begin UserController#user, userId: {}", userId);
        Mono<UserResponse> response = this.userService.getUserById(new UserId(userId))
                .map(UserResponse::new)
                .switchIfEmpty(Mono.just(new UserResponse(null)))
                .doAfterTerminate(() -> {
                    logger.info("Begin UserController#user, userId: {}", userId);
                });

        return response;
    }
}
