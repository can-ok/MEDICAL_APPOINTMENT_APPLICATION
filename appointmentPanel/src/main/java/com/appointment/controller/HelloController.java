package com.appointment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/admin/hello")
	public String getAdminHello() {
		return "Hello Admin";
	}
	
	@GetMapping("/user/hello")
	public String getUserHello() {
		return "Hello User";
	}
}
