package com.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ba.config.CustomUserDetails;
import com.ba.entity.Patient;

@Service
public class CustomPatientDetailService implements UserDetailsService{

	@Autowired
	PatientService patientService;
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Patient patinet=patientService.findByIdenticationNumber( username);
		return CustomUserDetails.fromPatientEntityToCustomUserDetails(patinet);
	}

}
