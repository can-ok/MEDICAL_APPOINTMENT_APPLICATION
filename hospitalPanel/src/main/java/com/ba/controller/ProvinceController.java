package com.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.dto.ProvinceDto;
import com.ba.entity.Province;
import com.ba.service.ProvinceService;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
@RestController
@RequestMapping("/provinces")
public class ProvinceController {
	
	@Autowired
	ProvinceService provinceService;
	
	@GetMapping
	public List<Province> getAllProvinces(){
		return provinceService.getAllProvinces();
	}
	
	@PostMapping
	public String saveProvince(@RequestBody ProvinceDto provinceDto) {
		return provinceService.insertProvince(provinceDto);
	}
	
}
