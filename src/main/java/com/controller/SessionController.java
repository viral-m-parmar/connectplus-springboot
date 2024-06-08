package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.DoctorEntity;
import com.entity.PatientEntity;
import com.repository.DoctorRepository;
import com.repository.PatientRepository;



@RestController
@RequestMapping("/public")
public class SessionController {

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody PatientEntity patient){
		
		patientRepo.save(patient);
		return ResponseEntity.ok(patient);
	}
	
	@PostMapping("/loginByPatient")
	public ResponseEntity<?> loginByPatient(@RequestBody PatientEntity patient){
		
		if(patientRepo.findByEmail(patient.getEmail()).isEmpty() || patientRepo.findByPassword(patient.getPassword()).isEmpty()) {
			
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
		}
		else {
			return ResponseEntity.ok(patient);
		}
		
	}
	
	@PostMapping("/loginByDoctor")
	public ResponseEntity<?> loginByDoctor(@RequestBody DoctorEntity doctor){
		
		if(doctorRepo.findByEmail(doctor.getEmail()).isEmpty() || doctorRepo.findByPassword(doctor.getPassword()).isEmpty()) {
			
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
		}
		else {
			return ResponseEntity.ok(doctor);
		}
		
	}
	
	
	
}
