package com.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.dto.PoliclinicDto;
import com.ba.entity.Policlinic;
import com.ba.repository.PoliclinicRepository;
import com.ba.utility.PoliclinicConverter;

@Service
public class PoliclinicService {
	
	
	@Autowired
	PoliclinicRepository policlinicRepository;
	
	
	public List<Policlinic> getPoliclinics(){
	
		return policlinicRepository.findAll();
	}
	

	public String savePoliclinc(PoliclinicDto policlinicDto) {
		
		Policlinic policlinic=PoliclinicConverter.toEntity(policlinicDto);
		
		policlinicRepository.save(policlinic);
		
		return "Succes";
		
	}

}
