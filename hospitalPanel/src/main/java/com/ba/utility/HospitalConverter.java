package com.ba.utility;

import com.ba.dto.HospitalDto;
import com.ba.dto.ProvinceDto;
import com.ba.entity.Hospital;
import com.ba.entity.Province;

public class HospitalConverter {
	
	public static Hospital toEntity(HospitalDto dto) {
        if (dto == null) {
            return null;
        } else {
        	Hospital entity = new Hospital();
        	
        	entity.setId(dto.getId());
        	entity.setName(dto.getName());
        	entity.setProvince(dto.getProvince());
        	entity.setPoliclinics(dto.getPoliclinics());
            return entity;
        }
    }
}
