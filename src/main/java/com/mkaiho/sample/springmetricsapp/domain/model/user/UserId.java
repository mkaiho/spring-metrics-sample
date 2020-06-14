package com.mkaiho.sample.springmetricsapp.domain.model.user;

import java.util.UUID;

public class UserId {
    private final UUID value;

    public UserId() {
        this.value = UUID.randomUUID();
    }

    public UserId(String value) {
        this.value = UUID.fromString(value);
    }

    public UUID value() {
        return value;
    }
}
