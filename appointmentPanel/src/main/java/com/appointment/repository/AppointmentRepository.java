package com.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
}
