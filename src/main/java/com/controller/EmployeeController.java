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

import com.entity.EmployeeEntity;
import com.repository.EmployeesRepository;

@RestController
@RequestMapping("/doctor")
public class EmployeeController {

	@Autowired
	EmployeesRepository employeeRepo;
	
	@PostMapping("/addEmployeeDetail")
	public ResponseEntity<?> addEmployeeDetail(@RequestBody EmployeeEntity employee){
		
		employeeRepo.save(employee);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/getAllEmployeesDetails")
	public ResponseEntity<?> getAllEmployeesDetails(){
		
		List<EmployeeEntity> employeesDetails = employeeRepo.findAll();
		return ResponseEntity.ok(employeesDetails);
	}
	
	@GetMapping("/getEmployeeDetailById/{employeeId}")
	public ResponseEntity<?> getEmployeeDetailById(@PathVariable("employeeId") Integer employeeId){
		
		EmployeeEntity employeeDetail = employeeRepo.findById(employeeId).get();
		return ResponseEntity.ok(employeeDetail);
	}
	
	@DeleteMapping("/deleteEmployeeById/{employeeId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("employeeId") Integer employeeId){
		
		EmployeeEntity employeeDetail = employeeRepo.findById(employeeId).get();
		employeeRepo.deleteById(employeeId);
		return ResponseEntity.ok(employeeDetail);
	}
	
	@PutMapping("/updateEmployeesDetail")
	public ResponseEntity<?> updateEmployeesDetail(@RequestBody EmployeeEntity employeeDetail){
		
		EmployeeEntity oldEmployeeDetail = employeeRepo.findById(employeeDetail.getEmployeeId()).get();
		
		if(employeeDetail.getFirstName() != null) {
			oldEmployeeDetail.setFirstName(employeeDetail.getFirstName());
		}
		if(employeeDetail.getLastName() != null) {
			oldEmployeeDetail.setLastName(employeeDetail.getLastName());
		}
		if(employeeDetail.getEmployeeTitleName() != null) {
			oldEmployeeDetail.setEmployeeTitleName(employeeDetail.getEmployeeTitleName());
		}
		if(employeeDetail.getGender() != null) {
			oldEmployeeDetail.setGender(employeeDetail.getGender());
		}
		if(employeeDetail.getEmail() != null) {
			oldEmployeeDetail.setEmail(employeeDetail.getEmail());
		}
		if(employeeDetail.getPassword() != null) {
			oldEmployeeDetail.setPassword(employeeDetail.getPassword());
		}
		if(employeeDetail.getDateOfJoining() != null) {
			oldEmployeeDetail.setDateOfJoining(employeeDetail.getDateOfJoining());
		}
		if(employeeDetail.getQualification() != null) {
			oldEmployeeDetail.setQualification(employeeDetail.getQualification());
		}
		if(employeeDetail.getRole() != null) {
			oldEmployeeDetail.setRole(employeeDetail.getRole());
		}
		if(employeeDetail.getAadharCardPath() != null) {
			oldEmployeeDetail.setAadharCardPath(employeeDetail.getAadharCardPath());
		}
		if(employeeDetail.getPanCardPath() != null) {
			oldEmployeeDetail.setPanCardPath(employeeDetail.getPanCardPath());
		}
		if(employeeDetail.getQualificationDocPath() != null) {
			oldEmployeeDetail.setQualificationDocPath(employeeDetail.getQualificationDocPath());
		}
		if(employeeDetail.getContactNum() != null) {
			oldEmployeeDetail.setContactNum(employeeDetail.getContactNum());
		}
		
		employeeRepo.save(oldEmployeeDetail);
		return ResponseEntity.ok(oldEmployeeDetail);
	}
	
	
}
