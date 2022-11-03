package com.example.purplepeople.service;

import com.example.purplepeople.domain.User;
import com.example.purplepeople.mapper.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public interface CustomUserDetailsService extends UserDetailsService {
}