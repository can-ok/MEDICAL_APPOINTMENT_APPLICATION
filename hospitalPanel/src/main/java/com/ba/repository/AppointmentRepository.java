package com.ba.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ba.entity.Appointment;
import com.ba.entity.Doctor;
import com.ba.entity.Role;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	List<Appointment> findByidentityNumber(String identityNumber);
	
	@Query("Select a.hour from Appointment a where a.date LIKE  CONCAT(:date,'%') AND  a.doctor.registrationNumber=:registrationNumber")
	List<String> getReservedHours(String date,Integer registrationNumber);
	
	List<Appointment> findByDate(Date date);
	
	List<Appointment> findByDoctor(Doctor doctor);
}
