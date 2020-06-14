package com.mkaiho.sample.springmetricsapp.application.service;

import com.mkaiho.sample.springmetricsapp.application.repository.UserRepository;
import com.mkaiho.sample.springmetricsapp.domain.model.user.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersResponse getAllUserResponse() {
        Users users = this.userRepository.findAll();
        return new UsersResponse(users);
    }

    public UserResponse getUserResponseById(UserId id) {
        User user = this.userRepository.findById(id);
        return new UserResponse(user);
    }
}
