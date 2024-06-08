package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.DoctorDocumentEntity;

public interface DoctorDocumentTypeRepository extends JpaRepository<DoctorDocumentEntity, Integer>{

}
