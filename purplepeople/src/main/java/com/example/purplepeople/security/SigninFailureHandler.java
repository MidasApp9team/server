package com.example.purplepeople.security;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String failCode = "99";
		
		if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
			failCode = "01";
		}

		HttpSession session = request.getSession();
		session.setAttribute("SIGNIN_FAIL_CODE", failCode);
		
		response.sendRedirect("/signin");
	}
}
