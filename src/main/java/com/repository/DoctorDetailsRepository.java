package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DoctorDetailsEntity;

public interface DoctorDetailsRepository extends JpaRepository<DoctorDetailsEntity, Integer>{

}
