package com.example.purplepeople.service.impl;

import com.example.purplepeople.domain.User;
import com.example.purplepeople.mapper.UserMapper;
import com.example.purplepeople.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getName(User user) {
        return user.getName();
    }
    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

}
