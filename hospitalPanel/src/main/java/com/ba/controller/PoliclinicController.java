package com.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.dto.PoliclinicDto;
import com.ba.entity.Policlinic;
import com.ba.service.PoliclinicService;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
@RestController
@RequestMapping("/policlinics")
public class PoliclinicController {
	
	
	@Autowired
	PoliclinicService policlinicService;
	
	@GetMapping
	public List<Policlinic> getAll(){
		return policlinicService.getPoliclinics();
	}
	
	@PostMapping
	public String savePoliclinic(@RequestBody PoliclinicDto policlinicDto){
		return policlinicService.savePoliclinc(policlinicDto);
	}
}
