package com.ba.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ba.dto.AppointmentDto;
import com.ba.entity.Appointment;
import com.ba.service.AppointmentService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping
	public List<Appointment> getAppointments(){
		return appointmentService.getAll();
	}
	
	
	@PostMapping
	public String saveAppointment(@RequestBody AppointmentDto appointmentDto)
	{
		return appointmentService.insertAppointment(appointmentDto);
	}
	
	@GetMapping(path="/find")
	public List<Appointment> getAppointmestbyIdentity(@RequestParam(value="id") String identityNumber){
		return appointmentService.getAllByIdentityNumber(identityNumber);
	}
	
	@GetMapping(path="/reserved")
	public List<String> getReserves(@RequestParam(value="date") String date){
		return appointmentService.getReservedHours(date);
	}
}
