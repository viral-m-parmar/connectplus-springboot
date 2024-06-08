package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EmployeeEntity;

public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Integer>{

}
