package com.ba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.dto.HospitalDto;
import com.ba.entity.Hospital;
import com.ba.entity.Province;
import com.ba.repository.HospitalRepository;
import com.ba.repository.ProvinceRepository;
import com.ba.utility.HospitalConverter;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	public List<Hospital> getAllHospital(){
		return hospitalRepository.findAll();
	}
	
	public List<Hospital> getHospitalByPlate(Integer plateCode) {
		Province province=provinceRepository.findBylicansePlate(plateCode);		
		return hospitalRepository.findAllByProvince(province);
	}
	
	public String saveHospital(HospitalDto dto) {
		Hospital hospital=HospitalConverter.toEntity(dto);
		hospitalRepository.save(hospital);
		
		return "Success";
	}
	
	public String deleteHospital(Integer id) {
		Optional<Hospital> byId=hospitalRepository.findById(id);
		if(byId.isPresent()) {
			hospitalRepository.delete(byId.get());
			return "Succes";
		}
		return "Fail";
	}

}
