package com.ba.utility;

import com.ba.dto.DoctorDto;
import com.ba.dto.ProvinceDto;
import com.ba.entity.Doctor;
import com.ba.entity.Province;

public class ProvinceConverter {
	
	public static Province toEntity(ProvinceDto dto) {
        if (dto == null) {
            return null;
        } else {
        	Province entity = new Province();
        	entity.setLicansePlate(dto.getLicansePlate());
        	entity.setName(dto.getName());
        	
            return entity;
        }
    }

}
