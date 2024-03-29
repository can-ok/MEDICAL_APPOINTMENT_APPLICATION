package com.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.entity.RoleEntity;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
	
	RoleEntity findByName(String name);
}
