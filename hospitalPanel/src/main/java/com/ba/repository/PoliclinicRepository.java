package com.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.entity.Policlinic;


@Repository
public interface PoliclinicRepository extends JpaRepository<Policlinic, Integer>{
	
	
	

}
