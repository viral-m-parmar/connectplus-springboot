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

import com.entity.RateListEntity;
import com.repository.RateListRepository;

@RestController
@RequestMapping("/doctor")
public class RateListController {

	@Autowired
	RateListRepository rateListRepo;
	
	@PostMapping("/addRateList")
	public ResponseEntity<?> addRateList(@RequestBody RateListEntity rateList){
		
		rateListRepo.save(rateList);
		return ResponseEntity.ok(rateList);
	}
	
	@GetMapping("/getAllRateList")
	public ResponseEntity<?> getAllRestList(){
		
		 List<RateListEntity> rateLists = rateListRepo.findAll();
		return ResponseEntity.ok(rateLists);
	}
	
	@GetMapping("/getRateListById/{rateListId}")
	public ResponseEntity<?> getRateListById(@PathVariable("rateListId") Integer rateListId){
		
		RateListEntity rateList = rateListRepo.findById(rateListId).get();
		return ResponseEntity.ok(rateList);
	}
	
	@DeleteMapping("/deleteRateById/{rateListId}")
	public ResponseEntity<?> deleteRateListById(@PathVariable("rateListId") Integer rateListId){
		
		RateListEntity rateList = rateListRepo.findById(rateListId).get();
		rateListRepo.deleteById(rateListId);
		return ResponseEntity.ok(rateList);
	}
	
	@PutMapping("/updateRateList")
	public ResponseEntity<?> updateRateList(@RequestBody RateListEntity rateList){
		
		RateListEntity oldRateList = rateListRepo.findById(rateList.getRateListId()).get();
		
		if(rateList.getRateListName() != null) {
			oldRateList.setRateListName(rateList.getRateListName());
		}
		if(rateList.getRateListAmount() != null) {
			oldRateList.setRateListAmount(rateList.getRateListAmount());
		}
		if(rateList.getDepartment() != null) {
			oldRateList.setDepartment(rateList.getDepartment());
		}
		if(rateList.getRateType() != null) {
			oldRateList.setRateType(rateList.getRateType());
		}
		
		rateListRepo.save(oldRateList);
		return ResponseEntity.ok(oldRateList);
	}
	
}
