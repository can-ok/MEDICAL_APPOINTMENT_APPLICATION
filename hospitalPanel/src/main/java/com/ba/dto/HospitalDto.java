package com.ba.dto;

import java.util.HashSet;
import java.util.Set;

import com.ba.entity.Policlinic;
import com.ba.entity.Province;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalDto {
	
	private Integer id;
	
	private String name;
	
	private Province province;
	
    private Set<Policlinic> policlinics;


}
