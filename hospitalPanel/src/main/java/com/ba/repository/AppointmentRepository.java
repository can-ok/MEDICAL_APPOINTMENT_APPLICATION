package com.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}
