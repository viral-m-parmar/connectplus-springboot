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

import com.entity.DoctorDetailsEntity;
import com.repository.DoctorDetailsRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorDetailsController {

	@Autowired
	DoctorDetailsRepository doctorDetailsRepo;
	
	@PostMapping("/addDoctorDetails")
	public ResponseEntity<?> addDoctorDetails(@RequestBody DoctorDetailsEntity doctorDetails){
		
		doctorDetailsRepo.save(doctorDetails);
		return ResponseEntity.ok(doctorDetails);
	}
	
	@GetMapping("/getAllDoctorDetails")
	public ResponseEntity<?> getAllDoctorDetails(){
		List<DoctorDetailsEntity> doctors = doctorDetailsRepo.findAll();
		return ResponseEntity.ok(doctors);
	}
	
	@GetMapping("/getDoctorDetailById/{doctorDetailId}")
	public ResponseEntity<?> getDoctorDetailById(@PathVariable("doctorDetailId") Integer doctorDetailId){
		
		DoctorDetailsEntity doctor = doctorDetailsRepo.findById(doctorDetailId).get();
		return ResponseEntity.ok(doctor);
	}
	
	@DeleteMapping("/deleteDoctorDetailById/{doctorDetailId}")
	public ResponseEntity<?> deleteDoctorDetailById(@PathVariable("doctorDetailId") Integer doctorDetailId){
		
		DoctorDetailsEntity doctor = doctorDetailsRepo.findById(doctorDetailId).get();
		doctorDetailsRepo.deleteById(doctorDetailId);
		return ResponseEntity.ok(doctor);
	}
	
	@PutMapping("/updateDoctorDetail")
	public ResponseEntity<?> updateDoctorDetail(@RequestBody DoctorDetailsEntity doctorDetail){
		
		DoctorDetailsEntity oldDoctorDetail = doctorDetailsRepo.findById(doctorDetail.getDoctorDetailsId()).get();
		
		if(doctorDetail.getFirstName() != null) {
			oldDoctorDetail.setFirstName(doctorDetail.getFirstName());
		}
		if(doctorDetail.getLastName() != null) {
			oldDoctorDetail.setLastName(doctorDetail.getLastName());
		}
		if(doctorDetail.getDoctorTitleName() != null) {
			oldDoctorDetail.setDoctorTitleName(doctorDetail.getDoctorTitleName());
		}
		if(doctorDetail.getQualification() != null) {
			oldDoctorDetail.setQualification(doctorDetail.getQualification());
		}
		if(doctorDetail.getSpecialization() != null) {
			oldDoctorDetail.setSpecialization(doctorDetail.getSpecialization());
		}
		if(doctorDetail.getEmail() != null) {
			oldDoctorDetail.setEmail(doctorDetail.getEmail());
		}
		if(doctorDetail.getPassword() != null) {
			oldDoctorDetail.setPassword(doctorDetail.getPassword());
		}
		if(doctorDetail.getContactNum() != null) {
			oldDoctorDetail.setContactNum(doctorDetail.getContactNum());
		}
		if(doctorDetail.getGender() != null) {
			oldDoctorDetail.setGender(doctorDetail.getGender());
		}
		if(doctorDetail.getJoiningDate() != null) {
			oldDoctorDetail.setJoiningDate(doctorDetail.getJoiningDate());
		}
		if(doctorDetail.getServiceType() != null) {
			oldDoctorDetail.setServiceType(doctorDetail.getServiceType());
		}
		
		doctorDetailsRepo.save(oldDoctorDetail);
		return ResponseEntity.ok(oldDoctorDetail);
	}
	
	
}
