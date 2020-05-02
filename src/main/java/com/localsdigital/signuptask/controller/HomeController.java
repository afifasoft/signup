package com.localsdigital.signuptask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		System.out.println("home");
		return "index";
	}
	
	@GetMapping("/app")
	public String app() {
		return "app";
	}
	
}
