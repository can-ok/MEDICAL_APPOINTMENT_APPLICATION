package com.ba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ba.dto.DoctorDto;
import com.ba.entity.Doctor;
import com.ba.entity.Patient;
import com.ba.entity.Role;
import com.ba.repository.DoctorRepository;
import com.ba.repository.RoleRepository;
import com.ba.utility.DoctorConverter;

@Service
@ComponentScan
public class DoctorService {
	
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Doctor> getAllDoctors(){
		
		return doctorRepository.findAll();
	}
	
	public String insertDoctor(DoctorDto doctorDto) {
		Role role=roleRepository.findByName("ROLE_USER");
		Doctor doctor = DoctorConverter.toEntity(doctorDto);
		doctor.setRole(role);
		doctor.setPassword(passwordEncoder.encode(doctorDto.getPassword()));
		doctorRepository.save(doctor);

		return "Success";
	}
	
	
	public List<Doctor> findDoctorsByParams(Integer policlinicId,Integer hospitalId){
		
		List<Doctor> doc=doctorRepository.findDoctorByParams(hospitalId,policlinicId);
		return doc;
	}
	
	
	
	public Doctor findByRegistrationN(Integer registrationNumber) {
		return doctorRepository.findByRegistrationNumber(registrationNumber);
	}
	
	public Doctor findByRegistraionNAndPassword(Integer registrationNumber,String password) {
		Doctor doctor=findByRegistrationN(registrationNumber);
		
		if(doctor!=null) {
			if(passwordEncoder.matches(password, doctor.getPassword())) {
				return doctor;
			}
		}
		return null;
	}

}
