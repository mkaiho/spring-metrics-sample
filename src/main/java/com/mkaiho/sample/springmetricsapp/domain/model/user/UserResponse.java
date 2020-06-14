package com.mkaiho.sample.springmetricsapp.domain.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
    @JsonProperty("user")
    private final UserResponseBody body;

    public UserResponse(User user) {
        this.body = user != null ? new UserResponseBody(user) : null;
    }

    private static class UserResponseBody {
        @JsonProperty("id")
        private final String id;
        @JsonProperty("name")
        private final String name;

        public UserResponseBody(User user) {
            this.id = user.id().value().toString();
            this.name = user.name();
        }
    }
}
