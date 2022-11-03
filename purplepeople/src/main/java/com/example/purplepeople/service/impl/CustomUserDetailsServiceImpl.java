package com.example.purplepeople.service.impl;

import com.example.purplepeople.domain.User;
import com.example.purplepeople.domain.UserForSecurity;
import com.example.purplepeople.mapper.UserMapper;
import com.example.purplepeople.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service(value = "customUserDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userMapper.getByEmpnum(username);
		
		if (user != null) {
			return UserForSecurity.builder()
					.user(user)
					.build();
		} else {
			throw new UsernameNotFoundException(username);
		}
	}
	
}
