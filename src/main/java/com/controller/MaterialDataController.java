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

import com.entity.MaterialEntity;
import com.repository.MaterialRepository;

@RestController
@RequestMapping("/doctor")
public class MaterialDataController {

	@Autowired
	MaterialRepository materialRepo;
	
	
	@PostMapping("/addMaterialData")
	public ResponseEntity<?> addMaterialData(@RequestBody MaterialEntity material){
		
		materialRepo.save(material);
		return ResponseEntity.ok(material);
	}
	
	@GetMapping("/getAllMaterialData")
	public ResponseEntity<?> getAllMaterialData(){

		List<MaterialEntity> materialsData = materialRepo.findAll();
		return ResponseEntity.ok(materialsData);
	}
	
	@GetMapping("/getMaterialDataById/{materialId}")
	public ResponseEntity<?> getMaterailDataById(@PathVariable("materialId") Integer materialId){
		
		MaterialEntity materialData = materialRepo.findById(materialId).get();
		return ResponseEntity.ok(materialData);
	}
	
	@DeleteMapping("/deleteMaterialData/{materialId}")
	public ResponseEntity<?> deleteMaterialDataById(@PathVariable("materialId") Integer materialId){
		
		MaterialEntity material = materialRepo.findById(materialId).get();
		materialRepo.deleteById(materialId);
		return ResponseEntity.ok(material);
	}
	
	@PutMapping("/updateMaterial")
	public ResponseEntity<?> updateMaterial(@RequestBody MaterialEntity materialData){
		
		MaterialEntity oldMaterialData = materialRepo.findById(materialData.getMaterialId()).get();
		
		if(materialData.getMaterialName() != null) {
			oldMaterialData.setMaterialName(materialData.getMaterialName());
		}
		if(materialData.getDescription() != null) {
			oldMaterialData.setDescription(materialData.getDescription());
		}
		materialRepo.save(oldMaterialData);
		return ResponseEntity.ok(oldMaterialData);
	}
}
