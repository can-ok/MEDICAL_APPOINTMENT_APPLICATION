package com.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appointment.entity.RoleEntity;
import com.appointment.entity.UserEntity;
import com.appointment.repository.RoleRepository;
import com.appointment.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserEntity saveUser(UserEntity userEntity) {
		RoleEntity userRole=roleRepository.findByName("ROLE_USER");
		userEntity.setRoleEntity(userRole);
		
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		
		return userRepository.save(userEntity);
	}
	
	
	public UserEntity findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
	
	public UserEntity findByLoginAndPassword(String login,String password) {
		UserEntity userEntity=findByLogin(login);
		if(userEntity !=null) {
			if(passwordEncoder.matches(password, userEntity.getPassword())) {
				return userEntity;
			}
		}
		
		return null;
	}
}
