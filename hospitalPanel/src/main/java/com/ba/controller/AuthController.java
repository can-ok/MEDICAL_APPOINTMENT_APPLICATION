package com.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ba.config.jwt.TokenManager;
import com.ba.dto.AuthRequest;
import com.ba.dto.AuthResponse;
import com.ba.dto.DoctorAuthRequest;
import com.ba.dto.DoctorDto;
import com.ba.dto.RegistrationRequest;
import com.ba.entity.Doctor;
import com.ba.entity.Patient;
import com.ba.service.DoctorService;
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
		pat.setName(registrationRequest.getName());
		pat.setSurname(registrationRequest.getSurname());
		pat.setMail(registrationRequest.getMail());
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
	
	@Autowired
	DoctorService doctorServce;
	
	
	@PostMapping("/register/doctor")
	public String registerDoctor(@RequestBody DoctorDto dto) {
		
		return doctorServce.insertDoctor(dto);
	}
	
	@PostMapping("/auth/doctor")
	public AuthResponse authDoctor(@RequestBody DoctorAuthRequest authRequest) {
		Doctor doc=doctorServce
				.findByRegistraionNAndPassword(authRequest.getRegistrationNumber(),authRequest.getPassword());
		String value=String.valueOf(doc.getRegistrationNumber());
		String token=tokenManager.generateToken(value);
		return new AuthResponse(token);
	}

	
}
