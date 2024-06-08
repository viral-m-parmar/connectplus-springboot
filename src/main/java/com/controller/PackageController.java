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

import com.entity.PackageEntity;
import com.repository.PackageRepository;

@RestController
@RequestMapping("/doctor")
public class PackageController {

	@Autowired
	PackageRepository packageRepo;
	
	@PostMapping("/addPackage")
	public ResponseEntity<?> addPackages(@RequestBody PackageEntity packageDetail){
		
		packageRepo.save(packageDetail);
		return ResponseEntity.ok(packageDetail);
	}
	
	@GetMapping("/getAllPackages")
	public ResponseEntity<?> getAllPackages(){
		
		 List<PackageEntity> packages = packageRepo.findAll();
		return ResponseEntity.ok(packages);
	}
	
	@GetMapping("/getPackageById/{packageId}")
	public ResponseEntity<?> getPackageById(@PathVariable("packageId") Integer packageId){
		
		PackageEntity packageDetail = packageRepo.findById(packageId).get();
		return ResponseEntity.ok(packageDetail);
	}
	
	@DeleteMapping("/deletePackageById/{packageId}")
	public ResponseEntity<?> deletePackageById(@PathVariable("packageId") Integer packageId){
		
		PackageEntity packageDetail = packageRepo.findById(packageId).get();
		packageRepo.deleteById(packageId);
		return ResponseEntity.ok(packageDetail);
	}
	
	@PutMapping("/updatePackage")
	public ResponseEntity<?> updatePackage(@RequestBody PackageEntity packageDetail){
		PackageEntity oldPackageDetail = packageRepo.findById(packageDetail.getPackageId()).get();
		
		if(packageDetail.getPackageName() != null) {
			oldPackageDetail.setPackageName(packageDetail.getPackageName());
		}
		if(packageDetail.getPackageAmount() != null) {
			oldPackageDetail.setPackageAmount(packageDetail.getPackageAmount());
		}
		if(packageDetail.getRateList() != null) {
			oldPackageDetail.setRateList(packageDetail.getRateList());
		}
		if(packageDetail.getPackageType() != null) {
			oldPackageDetail.setPackageType(packageDetail.getPackageType());
		}
		packageRepo.save(oldPackageDetail);
		return ResponseEntity.ok(oldPackageDetail);
	}
}
