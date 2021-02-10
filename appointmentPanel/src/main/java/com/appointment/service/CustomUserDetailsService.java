package com.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appointment.config.CustomUserDetails;
import com.appointment.entity.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userService.findByLogin(username);
		
		return CustomUserDetails.fomrUserEntityToCustomerUserDetails(userEntity);
	}

	
}
