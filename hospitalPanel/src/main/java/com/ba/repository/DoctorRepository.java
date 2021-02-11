package com.ba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ba.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	@Query("Select d from Doctor d where d.hospital.id=:hid AND d.policlinic.id=:pid")
	List<Doctor> findDoctorByParams(Integer hid,Integer pid);
	
	
	Doctor findByRegistrationNumber(Integer registrationNumber);

}
