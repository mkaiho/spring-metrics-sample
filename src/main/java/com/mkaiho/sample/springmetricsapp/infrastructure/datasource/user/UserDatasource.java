package com.mkaiho.sample.springmetricsapp.infrastructure.datasource.user;

import com.mkaiho.sample.springmetricsapp.application.repository.UserRepository;
import com.mkaiho.sample.springmetricsapp.domain.model.user.User;
import com.mkaiho.sample.springmetricsapp.domain.model.user.UserId;
import com.mkaiho.sample.springmetricsapp.domain.model.user.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UserDatasource implements UserRepository {
    private final UserMapper userMapper;

    public UserDatasource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Users findAll() {
        return new Users(this.userMapper.findAll());
    }

    public User findById(UserId id) {
        return this.userMapper.findById(id.value().toString());
    }
}
