package com.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.controller.ProvinceController;
import com.ba.dto.ProvinceDto;
import com.ba.entity.Province;
import com.ba.repository.ProvinceRepository;
import com.ba.utility.ProvinceConverter;

@Service
public class ProvinceService {
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	public List<Province> getAllProvinces(){
		return provinceRepository.findAll();
	}
	
	public String insertProvince(ProvinceDto dto) {
		
		Province province=ProvinceConverter.toEntity(dto);
		
		provinceRepository.save(province);
		
		return "Success";
	}

}
