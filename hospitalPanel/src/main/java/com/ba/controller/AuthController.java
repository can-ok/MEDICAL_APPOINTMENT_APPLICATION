package com.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ba.config.jwt.TokenManager;
import com.ba.dto.AuthRequest;
import com.ba.dto.AuthResponse;
import com.ba.dto.RegistrationRequest;
import com.ba.entity.Patient;
import com.ba.service.PatientService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
public class AuthController {
	
	@Autowired
	private PatientService patientService;

	@Autowired 
	private TokenManager tokenManager;
	
	@PostMapping("/register")
	public String registerPatient(@RequestBody RegistrationRequest registrationRequest) {
		Patient pat=new Patient();
		pat.setPassword(registrationRequest.getPassword());
		pat.setIdentityNumber(registrationRequest.getIdentityNumber());
		patientService.savePatient(pat);
		return "OK";
	}
	
	@PostMapping("/auth")
	public AuthResponse authentication(@RequestBody AuthRequest authRequest)
	{
		Patient patient=patientService.findByIdNumberAndPassword(authRequest.getIdentityNumber(), authRequest.getPassword());
		String token=tokenManager.generateToken(patient.getIdentityNumber());
		return new AuthResponse(token);
	}
	
}
