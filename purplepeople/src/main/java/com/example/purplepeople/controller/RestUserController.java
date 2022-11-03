package com.example.purplepeople.controller;

import com.example.purplepeople.domain.User;
import com.example.purplepeople.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class RestUserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/signup.do")
    @ModelAttribute()
    public int Signup(User user) {
        return userMapper.register(user);
    }

    @PostMapping("/signin.do")
    public Object Signin(User user) {
        return userMapper.getByEmpnum(user.getName());
    }
}
