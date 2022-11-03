package com.example.purplepeople.controller;

import com.example.purplepeople.domain.User;
import com.example.purplepeople.mapper.EmployeeMapper;
import com.example.purplepeople.mapper.UserMapper;
import com.example.purplepeople.security.JwtProvider;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import purple.common.controller.CommonRestControllerPrototype;
import purple.common.controller.RestControllerStrategy;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class RestUserController extends CommonRestControllerPrototype {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping("/signup.do")
    @ApiOperation("회원가입")
    public int Signup(@RequestBody User user) {
        System.out.println(user.getEmpnum());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccess("N");
        System.out.println(user.getAccess());
        return userMapper.register(user);
    }
    @PostMapping("/signin.do")
    @ApiOperation("토큰 발급")
    public ResponseEntity<?> Signin(@RequestBody User user) {
        User f_user = userMapper.getByEmpnum(user.getEmpnum());
        return controllerContext.execute(new RestControllerStrategy() {
            @Override
            public Object execute() {
                if (f_user == null) {
                    return "checkNum";
                } else if (passwordEncoder.matches(user.getPassword(), f_user.getPassword())) {
                    if(f_user.getGrant_emp().equals("N")) {
                        return "notyet";
                    } else {
                        String token = jwtProvider.createToken(user.getEmpnum());
                        return token;
                    }
                } else {
                    return "checkPw";
                }
            }
        });
    }
    @PostMapping("/get")
    @ApiOperation("사용자 모든 정보 요청")
    public ResponseEntity<?> get(//@RequestHeader(value = "Authorization") String token,
                                 @RequestBody User user) throws Exception {
        //Claims claims = jwtProvider.parseJwtToken(token);
        //if(claims.getSubject().equals(user.getEmpnum()))
        {
            User f_user = userMapper.getByEmpnum(user.getEmpnum());
            return controllerContext.execute(new RestControllerStrategy() {
                @Override
                public Object execute() {
                    if (f_user == null) {
                        return "checkNum";
                    } else if (passwordEncoder.matches(user.getPassword(), f_user.getPassword())) {
                        if (f_user.getGrant_emp().equals("Y")) {
                            return f_user;
                        } else {
                            return "notyet";
                        }
                    } else {
                        return "checkPw";
                    }
                }
            });
        } //else { return null; }
    }
    @PostMapping("/access")
    @ApiOperation("회원가입 허가")
    public String access(@RequestHeader(value = "Authorization") String token, @RequestBody User user) {
        Claims claims = jwtProvider.parseJwtToken(token);
        if("Y" == user.getAccess()) {
            userMapper.accessEdit(user.getEmpnum(), user.getAccess());
            return "";
        } else {
            return "low access";
        }
    }

    @PostMapping("/admin")
    @ApiOperation("관리자 유무 판단")
    public String admin(@RequestBody User user) {

        return userMapper.getByEmpnum(user.getEmpnum()).getAccess();
    }

    /*@PostMapping("/name")
    @ApiOperation("이름으로 회원 검색(테스트용)")
    public Object name(@RequestBody User user) {
        return controllerContext.execute(new RestControllerStrategy() {

            @Override
            public Object execute() {
                return userMapper.getByName(user.getName());
            }
        });
    }*/
}