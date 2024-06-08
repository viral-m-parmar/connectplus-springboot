package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.PatientEntity;
import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity, Integer>{
	
	 List<PatientEntity> findByEmail(String email);
	 List<PatientEntity> findByPassword(String password);
}
