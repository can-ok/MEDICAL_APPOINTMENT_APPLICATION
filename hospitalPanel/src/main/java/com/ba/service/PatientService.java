package com.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ba.entity.Patient;
import com.ba.entity.Role;
import com.ba.repository.PatientRepository;
import com.ba.repository.RoleRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Patient savePatient(Patient candPatient) {
		Role role=roleRepository.findByName("ROLE_USER");
		candPatient.setRole(role);
		candPatient.setPassword(passwordEncoder.encode(candPatient.getPassword()));
		
		return patientRepository.save(candPatient);
	}
	
	public Patient findByIdenticationNumber(String identifcatioNumber) {
		return patientRepository.findByIdentityNumber(identifcatioNumber);
	}
	
	
	public Patient findByIdNumberAndPassword(String identifcatioNumber,String password) {
		Patient patient=findByIdenticationNumber(identifcatioNumber);
		
		if(patient!=null) {
			if(passwordEncoder.matches(password, patient.getPassword())) {
				return patient;
			}
		}
		return null;
	}
	
}
