package com.ba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ba.dto.DoctorDto;
import com.ba.entity.Doctor;
import com.ba.repository.DoctorRepository;
import com.ba.utility.DoctorConverter;

@Service
@ComponentScan
public class DoctorService {
	
	
	@Autowired
	DoctorRepository doctorRepository;
	
	public List<Doctor> getAllDoctors(){
		
		return doctorRepository.findAll();
	}
	
	public String insertDoctor(DoctorDto doctorDto) {
		
		Doctor doctor = DoctorConverter.toEntity(doctorDto);
		doctorRepository.save(doctor);

		return "Success";
	}
	
	
	public List<Doctor> findDoctorsByParams(Integer policlinicId,Integer hospitalId){
		
		List<Doctor> doc=doctorRepository.findDoctorByParams(hospitalId,policlinicId);
		return doc;
	}

}
