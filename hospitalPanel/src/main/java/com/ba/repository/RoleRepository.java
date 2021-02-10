package com.ba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	
	Role findByName(String name);
}
