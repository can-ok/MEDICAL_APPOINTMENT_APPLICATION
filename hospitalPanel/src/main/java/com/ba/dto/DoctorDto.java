package com.ba.dto;


import com.ba.entity.Hospital;
import com.ba.entity.Policlinic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDto {
	
	private Integer registrationNumber;
	
	private String name;
		
	private String surname;

	private PoliclinicDto policlinic;
	
	private Hospital hospital;


}
