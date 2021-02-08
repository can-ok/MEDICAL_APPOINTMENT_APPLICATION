package com.ba.utility;

import com.ba.dto.DoctorDto;
import com.ba.entity.Doctor;

public class DoctorConverter {
	
	
	public static Doctor toEntity(DoctorDto dto) {
        if (dto == null) {
            return null;
        } else {
        	Doctor doctor = new Doctor();
        	
        	doctor.setRegistrationNumber(dto.getRegistrationNumber());
            doctor.setName(dto.getName());
            doctor.setSurname(dto.getSurname());
            doctor.setPoliclinic(PoliclinicConverter.toEntity(dto.getPoliclinic()));
            doctor.setHospital(dto.getHospital());
            return doctor;
        }
    }


}
