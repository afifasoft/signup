package com.localsdigital.signuptask.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.localsdigital.signuptask.model.User;
import com.localsdigital.signuptask.service.UserService;


@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String signupForm(Model model) {
		System.out.println("Sign up");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/register")
	public String processSignupForm(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		
		String email = user.getEmail();
		System.out.println("email: "+ email);
		System.out.println("user: "+user);
		userService.save(user);
		return "signup-confirmation";
	}
	
	public void logout(HttpSession session) {
		
	}
	
}
