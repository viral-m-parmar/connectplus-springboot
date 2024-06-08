package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ItemEntity;
import com.entity.PackageEntity;
import com.repository.ItemRepository;
import com.repository.PackageRepository;

@RestController
@RequestMapping("/doctor")
public class packageWithItemController {

	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	PackageRepository packageRepo;
	
	@PostMapping("/addPackageWithItem/{packageId}/{itemId}")
	public ResponseEntity<?> addPackageWithItem(@PathVariable Integer packageId, @PathVariable Integer itemId){
		
		ItemEntity item = itemRepo.findById(itemId).get();
		PackageEntity packageDetail = packageRepo.findById(packageId).get();
		
		packageDetail.getItems().add(item);
		packageRepo.save(packageDetail);
		return ResponseEntity.ok(packageDetail);
	}
	
}
