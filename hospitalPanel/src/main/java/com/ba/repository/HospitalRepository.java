package com.ba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.entity.Hospital;
import com.ba.entity.Province;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	List<Hospital> findAllByProvince(Province province);
}
