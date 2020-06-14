package com.mkaiho.sample.springmetricsapp.infrastructure.datasource.user;

import com.mkaiho.sample.springmetricsapp.domain.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(@Param("id") String id);
}
