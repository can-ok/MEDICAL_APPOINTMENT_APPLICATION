package com.ba.dto;

import java.util.Date;

import com.ba.entity.Doctor;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AppointmentDto {
	
	private Integer id;
	
	private String identityNumber;
	
	private String province;
	
	private String hospital;
	
	private String policlinc;
	
	private Doctor doctor;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;
	
	private String hour;

}
