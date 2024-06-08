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

import com.entity.DoctorDocumentEntity;
import com.repository.DoctorDocumentTypeRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorDocumentController {
	
	@Autowired
	DoctorDocumentTypeRepository doctorDocTypeRepo;
	
	@PostMapping("/addDoctorDocument")
	public ResponseEntity<?> addDoctorDocument(@RequestBody DoctorDocumentEntity doctorDocument){
		
		doctorDocTypeRepo.save(doctorDocument);
		return ResponseEntity.ok(doctorDocument);
	}
	
	@GetMapping("/getAllDoctorDocument")
	public ResponseEntity<?> getAllDoctorDocument(){
		
		List<DoctorDocumentEntity> doctorDocument = doctorDocTypeRepo.findAll();
		return ResponseEntity.ok(doctorDocument);
	}
	
	@GetMapping("/getDoctorDocumentById/{doctorDocumentId}")
	public ResponseEntity<?> getDoctorDocumentById(@PathVariable("doctorDocumentId") Integer doctorDocumentId){
		
		DoctorDocumentEntity doctorDocument = doctorDocTypeRepo.findById(doctorDocumentId).get();
		return ResponseEntity.ok(doctorDocument);
	}
	
	@DeleteMapping("/deleteDoctorDocumentById/{doctorDocumentId}")
	public ResponseEntity<?> deleteDoctorDocumentById(@PathVariable("doctorDocumentId") Integer doctorDocumentId){
		
		DoctorDocumentEntity doctorDocument = doctorDocTypeRepo.findById(doctorDocumentId).get();
		doctorDocTypeRepo.deleteById(doctorDocumentId);
		return ResponseEntity.ok(doctorDocument);
	}
	
	@PutMapping("/updateDoctorDocumentDetail")
	public ResponseEntity<?> updateDoctorDocumentDetail(@RequestBody DoctorDocumentEntity doctorDocumentDetail){
		
		DoctorDocumentEntity oldDoctorDocumentDetail = doctorDocTypeRepo.findById(doctorDocumentDetail.getDoctorDocumentId()).get();
		
		if(doctorDocumentDetail.getDoctorDocumentName() != null) {
			oldDoctorDocumentDetail.setDoctorDocumentName(doctorDocumentDetail.getDoctorDocumentName());
		}
		if(doctorDocumentDetail.getDoctorDocumentPath() != null) {
			oldDoctorDocumentDetail.setDoctorDocumentPath(doctorDocumentDetail.getDoctorDocumentPath());
		}
		if(doctorDocumentDetail.getDoctor() != null) {
			oldDoctorDocumentDetail.setDoctor(doctorDocumentDetail.getDoctor());
		}
		
		doctorDocTypeRepo.save(oldDoctorDocumentDetail);
		return ResponseEntity.ok(oldDoctorDocumentDetail);
	}
	
	
}
