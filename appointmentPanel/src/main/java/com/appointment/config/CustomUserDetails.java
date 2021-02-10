package com.appointment.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.appointment.entity.UserEntity;

public class CustomUserDetails implements UserDetails{
	
	
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> grantedAuthorities;
	
	
	public static CustomUserDetails fomrUserEntityToCustomerUserDetails(UserEntity userEntity) {
		CustomUserDetails c=new CustomUserDetails();
		c.login=userEntity.getLogin();
		c.password=userEntity.getPassword();
		c.grantedAuthorities=Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRoleEntity().getName()));
		return c;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
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
