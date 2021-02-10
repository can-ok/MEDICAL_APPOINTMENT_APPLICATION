package com.ba.utility;

import com.ba.dto.AppointmentDto;
import com.ba.dto.DoctorDto;
import com.ba.entity.Appointment;
import com.ba.entity.Doctor;

public class AppointmentConverter {
	
	
	public static Appointment toEntity(AppointmentDto dto) {
        if (dto == null) {
            return null;
        } else {
        	Appointment ap = new Appointment();
        	
        	ap.setDate(dto.getDate());
        	//ap.setDoctor(dto.getDoctor());
        	ap.setHospital(dto.getHospital());
        	ap.setHour(dto.getHour());
        	ap.setId(dto.getId());
        	ap.setIdentityNumber(dto.getIdentityNumber());
        	ap.setPoliclinc(dto.getPoliclinc());
        	ap.setProvince(dto.getProvince());
            return ap;
        }
    }
}
