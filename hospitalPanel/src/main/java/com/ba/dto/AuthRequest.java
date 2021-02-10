package com.ba.dto;

import lombok.Data;

@Data
public class AuthRequest {
	private String identityNumber;
	private String password;
}
