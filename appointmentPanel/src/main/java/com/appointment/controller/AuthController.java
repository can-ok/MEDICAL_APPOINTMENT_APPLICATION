package com.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.config.jwt.JwtProvider;
import com.appointment.dto.AuthRequest;
import com.appointment.dto.AuthResponse;
import com.appointment.dto.RegistrationRequest;
import com.appointment.entity.UserEntity;
import com.appointment.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService UserService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
		UserEntity u=new UserEntity();
		u.setPassword(registrationRequest.getPassword());
		u.setLogin(registrationRequest.getLogin());
		UserService.saveUser(u);
		return "OK";
	}
	
	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		UserEntity user=UserService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token=jwtProvider.generateToken(user.getLogin());
		return new AuthResponse(token);
	}
	
}
