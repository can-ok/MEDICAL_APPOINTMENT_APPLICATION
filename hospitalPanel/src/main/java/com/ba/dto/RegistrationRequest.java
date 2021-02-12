package com.ba.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
	private String identityNumber;
	private String password;
	private String name;
	private String surname;
	private String mail;


}
