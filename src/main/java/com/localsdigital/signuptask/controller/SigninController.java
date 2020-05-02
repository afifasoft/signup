package com.localsdigital.signuptask.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {
	
	@GetMapping("/login")
	public String signinForm() {
		System.out.println("SIGNIN");
		return "signin";
	}
	
	@GetMapping("/logout")
	public String logoutSuccess(HttpSession session) {
		
		return "index";
	}
 
	
}
