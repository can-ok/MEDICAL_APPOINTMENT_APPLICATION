package com.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ba.dto.DoctorDto;
import com.ba.entity.Doctor;
import com.ba.service.DoctorService;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
@RestController
@RequestMapping(path="/doctors")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@GetMapping
	public List<Doctor> getDoctors(){
		
		return doctorService.getAllDoctors();
	}
	
	@PostMapping
	public String saveDoctor(@RequestBody DoctorDto dto) {
		
		return doctorService.insertDoctor(dto);
	}
	
	@GetMapping
	public List<Doctor> getDoctorsByPoliclinicAndHospital
	(@RequestParam(value="policlinic") Integer policlinicId,
			@RequestParam(value="hospital") Integer hospitalId){
		
		return null;

	}
	
	
	
}
