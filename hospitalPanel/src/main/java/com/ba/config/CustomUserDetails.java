package com.ba.config;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ba.entity.Doctor;
import com.ba.entity.Patient;


public class CustomUserDetails implements UserDetails{
	
	private String identityNumber;
	private String password;
	private Collection<? extends GrantedAuthority> grantedAuth;
	
	public static CustomUserDetails fromPatientEntityToCustomUserDetails(Patient patient)
	{
		CustomUserDetails c=new CustomUserDetails();
		c.identityNumber=patient.getIdentityNumber();
		c.password=patient.getPassword();
		c.grantedAuth=Collections.singletonList(new SimpleGrantedAuthority(patient.getRole().getName()));
		return c;
	}
	
	public static CustomUserDetails fromDoctorEntityToCustomUserDetails(Doctor doctor)
	{
		CustomUserDetails c=new CustomUserDetails();
		c.identityNumber= String.valueOf(doctor.getRegistrationNumber());
		c.password=doctor.getPassword();
		c.grantedAuth=Collections.singletonList(new SimpleGrantedAuthority(doctor.getRole().getName()));
		return c;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return identityNumber;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
