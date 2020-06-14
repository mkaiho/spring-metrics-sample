package com.mkaiho.sample.springmetricsapp.domain.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class UsersResponse {
    @JsonProperty("users")
    private final List<UserResponse> users;

    public UsersResponse(Users users) {
        this.users = users.stream()
                .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
    }
}
