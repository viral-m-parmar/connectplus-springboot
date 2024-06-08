package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.PatientEntity;
import com.repository.PatientRepository;

@RestController
@RequestMapping("/doctor")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepo;
	
	@GetMapping("/getAllPatients")
	public ResponseEntity<?> getAllPatients(){
		
		List<PatientEntity> patients = patientRepo.findAll();
		return ResponseEntity.ok(patients);
	}
	
	@GetMapping("/getPatientById/{patientId}")
	public ResponseEntity<?> getPatientById(@PathVariable("patientId") Integer patientId){
		
		PatientEntity patient = patientRepo.findById(patientId).get();
		return ResponseEntity.ok(patient);
	}	
	
	@DeleteMapping("/deletePatientById/{patientId}")
	public ResponseEntity<?> deletePatientById(@PathVariable("patientId") Integer patientId){
		 
		PatientEntity patient = patientRepo.findById(patientId).get();
		patientRepo.deleteById(patientId);
		return ResponseEntity.ok(patient);
	}
	
	@PutMapping("/updatePatient")
	public ResponseEntity<?> updatePatient(@RequestBody PatientEntity updatePatientDetail){
		
		PatientEntity oldPatientDetail = patientRepo.findById(updatePatientDetail.getPatientId()).get();
		
		if(updatePatientDetail.getAdressLine() != null) {
			oldPatientDetail.setAdressLine(updatePatientDetail.getAdressLine());
		}
		if(updatePatientDetail.getBloodGrp() != null) {
			oldPatientDetail.setBloodGrp(updatePatientDetail.getBloodGrp());
		}
		if(updatePatientDetail.getBranch() != null) {
			oldPatientDetail.setBranch(updatePatientDetail.getBloodGrp());
		}
		if(updatePatientDetail.getCity() != null) {
			oldPatientDetail.setCity(updatePatientDetail.getCity());
		}
		if(updatePatientDetail.getCountry() != null) {
			oldPatientDetail.setCountry(updatePatientDetail.getCountry());
		}
		if(updatePatientDetail.getDiseases() != null) {
			oldPatientDetail.setDiseases(updatePatientDetail.getDiseases());
		}
		if(updatePatientDetail.getDocumentType() != null) {
			oldPatientDetail.setDocumentType(updatePatientDetail.getDocumentType());
		}
		if(updatePatientDetail.getEmail() != null) {
			oldPatientDetail.setEmail(updatePatientDetail.getEmail());
		}
		if(updatePatientDetail.getFirstName() != null) {
			oldPatientDetail.setFirstName(updatePatientDetail.getFirstName());
		}
		if(updatePatientDetail.getGender() != null) {
			oldPatientDetail.setGender(updatePatientDetail.getGender());
		}
		if(updatePatientDetail.getIdNum() != null) {
			oldPatientDetail.setIdNum(updatePatientDetail.getIdNum());
		}
		if(updatePatientDetail.getInit() != null) {
			oldPatientDetail.setInit(updatePatientDetail.getInit());
		}
		if(updatePatientDetail.getLastName() != null) {
			oldPatientDetail.setLastName(updatePatientDetail.getLastName());
		}
		if(updatePatientDetail.getMaritalStatus() != null) {
			oldPatientDetail.setMaritalStatus(updatePatientDetail.getMaritalStatus());
		}
		if(updatePatientDetail.getMiddleName() != null) {
			oldPatientDetail.setMiddleName(updatePatientDetail.getMiddleName());
		}
		if(updatePatientDetail.getMobileNumber() != null) {
			oldPatientDetail.setMobileNumber(updatePatientDetail.getMobileNumber());
		}
		if(updatePatientDetail.getMrd_no() != null) {
			oldPatientDetail.setMrd_no(updatePatientDetail.getMrd_no());
		}
		if(updatePatientDetail.getOccupation() != null) {
			oldPatientDetail.setOccupation(updatePatientDetail.getOccupation());
		}
		if(updatePatientDetail.getPassword() != null) {
			oldPatientDetail.setPassword(updatePatientDetail.getPassword());
		}
		if(updatePatientDetail.getPatientPhoto() != null) {
			oldPatientDetail.setPatientPhoto(updatePatientDetail.getPatientPhoto());
		}
		if(updatePatientDetail.getPinCode() != null) {
			oldPatientDetail.setPinCode(updatePatientDetail.getPinCode());
		}
		if(updatePatientDetail.getRateList() != null) {
			oldPatientDetail.setRateList(updatePatientDetail.getRateList());
		}
		if(updatePatientDetail.getRefferdBy() != null) {
			oldPatientDetail.setRefferdBy(updatePatientDetail.getRefferdBy());
		}
		if(updatePatientDetail.getRegistrationType() != null) {
			oldPatientDetail.setRegistrationType(updatePatientDetail.getRegistrationType());
		}
		if(updatePatientDetail.getRemark() != null) {
			oldPatientDetail.setRemark(updatePatientDetail.getRemark());
		}
		if(updatePatientDetail.getState() != null) {
			oldPatientDetail.setState(updatePatientDetail.getState());
		}
			
		patientRepo.save(oldPatientDetail);		
		return ResponseEntity.ok(oldPatientDetail);
	}
	
	
	
}
