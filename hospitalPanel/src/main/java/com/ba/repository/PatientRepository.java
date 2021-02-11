package com.ba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{	
	Patient findByIdentityNumber(String identityNumber);
}
