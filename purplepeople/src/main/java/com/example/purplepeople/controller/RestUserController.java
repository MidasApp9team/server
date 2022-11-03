package com.example.purplepeople.controller;

import com.example.purplepeople.domain.User;
import com.example.purplepeople.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import purple.common.controller.CommonRestControllerPrototype;
import purple.common.controller.RestControllerStrategy;

@RestController
@RequestMapping("/api/user")
public class RestUserController extends CommonRestControllerPrototype {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup.do")
    @ApiOperation("회원가입")
    public int Signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmpnum(null);
        return userMapper.register(user);
    }
    @PostMapping("/signin.do")
    @ApiOperation("로그인")
    public ResponseEntity<?> Signin(@RequestBody User user) {
        User f_user = userMapper.getByEmpnum(user.getEmpnum());
        return controllerContext.execute(new RestControllerStrategy() {
            @Override
            public Object execute() {
                if (f_user == null) {
                    return "checkNum";
                } else if (passwordEncoder.matches(user.getPassword(), f_user.getPassword())) {
                    return f_user;
                } else {
                    return "checkPw";
                }
            }
        });
    }
    @PostMapping("/access")
    @ApiOperation("회원가입 허가")
    public int access(@RequestBody User user) {
        return userMapper.accessEdit(user.getEmpnum(), user.getAccess());
    }

    @PostMapping("/name")
    @ApiOperation("이름으로 회원 검색(테스트용)")
    public Object name(@RequestBody User user) {
        return controllerContext.execute(new RestControllerStrategy() {

            @Override
            public Object execute() {
                return userMapper.getByName(user.getName());
            }
        });
    }
}