package com.localsdigital.signuptask.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.localsdigital.signuptask.model.User;
import com.localsdigital.signuptask.service.UserService;

@Component
public class CustomAuthenticationSucessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("onAuthenticationSuccess");
		
		String email = authentication.getName();
		System.out.println("email: "+ email);
		
		User theUser = userService.findByEmail(email);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);
		response.sendRedirect("/app");
	}
	
	
}
