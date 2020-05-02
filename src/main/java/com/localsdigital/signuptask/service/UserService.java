package com.localsdigital.signuptask.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.localsdigital.signuptask.model.User;

public interface UserService  extends UserDetailsService{
	public void save(User user);
	public User findByEmail(String email);
	
}
