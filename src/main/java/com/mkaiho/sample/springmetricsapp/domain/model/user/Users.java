package com.mkaiho.sample.springmetricsapp.domain.model.user;

import java.util.List;
import java.util.stream.Stream;

public class Users {
    private final List<User> list;

    public Users(List<User> list) {
        if (list == null) {
            this.list = List.of();
        } else {
            this.list = List.copyOf(list);
        }
    }

    public Stream<User> stream() {
        return this.list.stream();
    }
}
