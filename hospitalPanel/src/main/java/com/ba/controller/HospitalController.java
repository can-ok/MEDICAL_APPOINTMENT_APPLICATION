package com.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.dto.HospitalDto;
import com.ba.entity.Hospital;
import com.ba.service.HospitalService;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
@RestController
@RequestMapping("/hospitals")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping
	public List<Hospital> getHospitals(){
		return hospitalService.getAllHospital();
	}
	
	@GetMapping("/{plateCode}")
	public List<Hospital> getHospital(@PathVariable Integer plateCode) {
		return hospitalService.getHospitalByPlate(plateCode);
	}
	
	@PostMapping
	public String insertHospital(@RequestBody HospitalDto hospitalDto) {
		
		return hospitalService.saveHospital(hospitalDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteHospital(@PathVariable Integer id) {
		return hospitalService.deleteHospital(id);
	}

}
