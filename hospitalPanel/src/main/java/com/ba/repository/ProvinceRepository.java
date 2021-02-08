package com.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.entity.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer>{
		
	Province findBylicansePlate(Integer licansePlate);
}
