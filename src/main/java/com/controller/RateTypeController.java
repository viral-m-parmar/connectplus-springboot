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

import com.entity.RateTypeEntity;
import com.repository.RateTypeRepository;

@RestController
@RequestMapping("/doctor")
public class RateTypeController {

	@Autowired
	RateTypeRepository rateTypeRepo;
	
	@PostMapping("/addRateType")
	public ResponseEntity<?> addRateTypeName(@RequestBody RateTypeEntity ratetype){
		
		rateTypeRepo.save(ratetype);
		return ResponseEntity.ok(ratetype);
	}
	
	@GetMapping("/getAllRateType")
	public ResponseEntity<?> getAllRateType(){

		List<RateTypeEntity> rateTypes = rateTypeRepo.findAll();
		return ResponseEntity.ok(rateTypes);
	}
	
	@GetMapping("/getRateTypeById/{rateTypeId}")
	public ResponseEntity<?> getRateTypeById(@PathVariable("rateTypeId") Integer rateTypeId){
		
		RateTypeEntity rateType = rateTypeRepo.findById(rateTypeId).get();
		return ResponseEntity.ok(rateType);
	}
	
	@DeleteMapping("/deleteRateType/{rateTypeId}")
	public ResponseEntity<?> deleteRateTypeById(@PathVariable("rateTypeId") Integer rateTypeId){
		
		RateTypeEntity rateType = rateTypeRepo.findById(rateTypeId).get();
		rateTypeRepo.deleteById(rateTypeId);
		return ResponseEntity.ok(rateType);
	}
	
	@PutMapping("/updateRateType")
	public ResponseEntity<?> updateRateType(@RequestBody RateTypeEntity Entity){
		
		RateTypeEntity oldRateType = rateTypeRepo.findById(Entity.getRateTypeId()).get();
		
		if(Entity.getRateTypeName() != null) {
			oldRateType.setRateTypeName(Entity.getRateTypeName());
		}
		rateTypeRepo.save(oldRateType);
		return ResponseEntity.ok(oldRateType);
	}
	
	
	
}
