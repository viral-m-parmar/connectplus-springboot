package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DoctorEntity;
import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer>{

	List<DoctorEntity> findByEmail(String email);
	List<DoctorEntity> findByPassword(String password);

}
