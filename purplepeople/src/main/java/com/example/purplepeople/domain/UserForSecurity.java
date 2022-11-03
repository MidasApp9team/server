package com.example.purplepeople.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserForSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@NonNull
	private User user;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_NONE");
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(authority);
		
		if (user.getAccess() == "N") {
			authority = new SimpleGrantedAuthority("ROLE_USER");
			authorities.add(authority);
		} else if (user.getAccess() == "A") {
			authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			authorities.add(authority);
		}

		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		if (user != null) {
			return ("N".equals(user.getGrant_emp()));
		}

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if (user != null) {
			return ("Y".equals(user.getGrant_emp()));
		}

		return true;
	}

	@Override
	public String getPassword() {
		return ((user != null) ? user.getPassword() : null);
	}

	@Override
	public String getUsername() {
		return ((user != null) ? user.getEmpnum() : null);
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
