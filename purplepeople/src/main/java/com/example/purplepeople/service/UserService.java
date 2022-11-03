package com.example.purplepeople.service;

import com.example.purplepeople.domain.User;

public interface UserService {
    public String getName(User user);
    public int register(User user);
}
