package com.mkaiho.sample.springmetricsapp.application.service;

import com.mkaiho.sample.springmetricsapp.application.repository.UserRepository;
import com.mkaiho.sample.springmetricsapp.domain.model.user.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Users> getAllUser() {
        Mono<Users> users = Mono.fromSupplier(this.userRepository::findAll);
        return users;
    }

    public Mono<User> getUserById(UserId id) {
        Mono<User> user = Mono
                .fromSupplier(() -> this.userRepository.findById(id));
        return user;
    }
}
