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

import com.entity.ServiceTypeEntity;
import com.repository.ServiceTypeRepository;

@RestController
@RequestMapping("/doctor")
public class ServiceTypeController {

	@Autowired
	ServiceTypeRepository serviceTypeRepo;
	
	@PostMapping("/addServiceType")
	public ResponseEntity<?> addServiceType(@RequestBody ServiceTypeEntity serviceType){
		
		serviceTypeRepo.save(serviceType);
		return ResponseEntity.ok(serviceType);
	}
	
	@GetMapping("/getAllServiceType")
	public ResponseEntity<?> getAllServiceType(){
		
		List<ServiceTypeEntity> serviceTypes = serviceTypeRepo.findAll();
		return ResponseEntity.ok(serviceTypes);
	}
	
	@GetMapping("/getServiceTypeById/{serviceTypeId}")
	public ResponseEntity<?> getServiceTypeById(@PathVariable("serviceTypeId") Integer serviceTypeId){
		
		ServiceTypeEntity serviceType = serviceTypeRepo.findById(serviceTypeId).get();
		return ResponseEntity.ok(serviceType);
	}
	
	@DeleteMapping("/deleteServiceTypeById/{serviceTypeId}")
	public ResponseEntity<?> deleteServiceTypeById(@PathVariable("serviceTypeId") Integer serviceTypeId){
		
		ServiceTypeEntity serviceType = serviceTypeRepo.findById(serviceTypeId).get();
		serviceTypeRepo.deleteById(serviceTypeId);
		return ResponseEntity.ok(serviceType);
	}
	
	@PutMapping("/updateServiceType")
	public ResponseEntity<?> updateServiceType(@RequestBody ServiceTypeEntity serviceType){
		
		ServiceTypeEntity oldServiceType = serviceTypeRepo.findById(serviceType.getServiceTypeId()).get();
		
		if(serviceType.getServiceTypeName() != null) {
			oldServiceType.setServiceTypeName(serviceType.getServiceTypeName());
		}
		
		serviceTypeRepo.save(oldServiceType);
		return ResponseEntity.ok(oldServiceType);
	}
	
	
}
