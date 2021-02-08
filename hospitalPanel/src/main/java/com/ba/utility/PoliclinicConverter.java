package com.ba.utility;

import com.ba.dto.PoliclinicDto;
import com.ba.entity.Policlinic;

public class PoliclinicConverter {
	
	
	public static Policlinic toEntity(PoliclinicDto dto) {
        if (dto == null) {
            return null;
        } else {
        	Policlinic entity = new Policlinic();
        	entity.setName(dto.getName());
        	entity.setId(dto.getId());
            return entity;
        }
    }

}
