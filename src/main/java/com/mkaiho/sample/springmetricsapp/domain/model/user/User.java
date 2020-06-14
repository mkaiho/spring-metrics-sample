package com.mkaiho.sample.springmetricsapp.domain.model.user;

public class User {
    private final UserId id;
    private String name;

    public User(String name) {
        this(new UserId(), name);
    }

    public User(UserId id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserId id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }
}
