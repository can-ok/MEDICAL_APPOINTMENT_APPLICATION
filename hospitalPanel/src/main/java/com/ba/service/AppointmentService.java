package com.ba.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.dto.AppointmentDto;
import com.ba.entity.Appointment;
import com.ba.entity.Doctor;
import com.ba.repository.AppointmentRepository;
import com.ba.repository.DoctorRepository;
import com.ba.utility.AppointmentConverter;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	public String insertAppointment(AppointmentDto appointmentDto) {
	
		Appointment appointment=AppointmentConverter.toEntity(appointmentDto);
		Doctor doctor=doctorRepository.findByRegistrationNumber(appointmentDto.getDoctor().getRegistrationNumber());
		appointment.setDoctor(doctor);
		appointmentRepository.save(appointment);
		return "Succes";
	}
	
	public List<Appointment> getAll(){
		return appointmentRepository.findAll();
	}
	
	public List<Appointment> getAllByIdentityNumber(String identityNumber){
		return appointmentRepository.findByidentityNumber(identityNumber);
	}
	
	
	public List<String> getReservedHours(String date){
		
		return appointmentRepository.getReservedHours(date);
	}
	
}
