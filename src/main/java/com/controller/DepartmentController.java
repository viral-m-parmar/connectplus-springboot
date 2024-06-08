package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.DepartmentEntity;
import com.repository.DepartmentRepository;

@RestController
@RequestMapping("/doctor")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepo;
	
	@PostMapping("/addDepartment")
	public ResponseEntity<?> addDepartment(@RequestBody DepartmentEntity department){
		
		departmentRepo.save(department);
		return ResponseEntity.ok(department);
	}
	
	@GetMapping("/getAllDepartment")
	public ResponseEntity<?> getAllDepartment(){

		List<DepartmentEntity> departments = departmentRepo.findAll();
		return ResponseEntity.ok(departments);
	}
	
	@GetMapping("/getDepartmentById/{departmentId}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("departmentId") Integer departmentId){
		
		DepartmentEntity department = departmentRepo.findById(departmentId).get();
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("/deleteDepartment/{departmentId}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable("departmentId") Integer departmentId){
		
		DepartmentEntity department = departmentRepo.findById(departmentId).get();
		departmentRepo.deleteById(departmentId);
		return ResponseEntity.ok(department);
	}
	
	@PutMapping("/updateDepartment")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentEntity department){
		
		DepartmentEntity oldDepartment = departmentRepo.findById(department.getDepartmentId()).get();
		
		if(department.getDepartmentName() != null) {
			oldDepartment.setDepartmentName(department.getDepartmentName());
		}
		
		departmentRepo.save(oldDepartment);
		return ResponseEntity.ok(oldDepartment);
	}
}
