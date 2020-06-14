package com.mkaiho.sample.springmetricsapp.application.repository;

import com.mkaiho.sample.springmetricsapp.domain.model.user.User;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UserId;
import com.mkaiho.sample.springmetricsapp.domain.model.user.Users;

public interface UserRepository {
    Users findAll();

    User findById(UserId id);
}
