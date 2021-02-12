package com.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ba.config.CustomUserDetails;
import com.ba.entity.Doctor;
import com.ba.entity.Patient;

@Service
public class CustomPatientDetailService implements UserDetailsService{

	@Autowired
	PatientService patientService;
	
	@Autowired
	DoctorService doctorService;
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Patient patinet=patientService.findByIdenticationNumber( username);
		if(patinet!=null) {
			return CustomUserDetails.fromPatientEntityToCustomUserDetails(patinet);
		}
		Doctor doctor=doctorService.findByRegistrationN(Integer.parseInt(username));
		if(doctor!=null) {
			return CustomUserDetails.fromDoctorEntityToCustomUserDetails(doctor);
		}
		return null;
	}

}
