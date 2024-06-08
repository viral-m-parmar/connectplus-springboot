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

import com.entity.ItemEntity;
import com.repository.ItemRepository;

@RestController
@RequestMapping("/doctor")
public class ItemController {

	@Autowired
	ItemRepository itemRepo;
	
	@PostMapping("/addItem")
	public ResponseEntity<?> addItems(@RequestBody ItemEntity item){
		
		itemRepo.save(item);
		return ResponseEntity.ok(item);
	}
	
	@GetMapping("/getAllItems")
	public ResponseEntity<?> getAllItems(){
		
		List<ItemEntity> items = itemRepo.findAll();
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/getItemById/{itemId}")
	public ResponseEntity<?> getItemById(@PathVariable("itemId") Integer itemId){
		
		ItemEntity item = itemRepo.findById(itemId).get();
		return ResponseEntity.ok(item);
	}
	
	@DeleteMapping("/deleteItemById/{itemId}")
	public ResponseEntity<?> deleteItemById(@PathVariable("itemId") Integer itemId){
		
		ItemEntity item = itemRepo.findById(itemId).get();
		itemRepo.deleteById(itemId);
		return ResponseEntity.ok(item);
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity<?> updateItem(@RequestBody ItemEntity item){
		
		ItemEntity oldItemDetail = itemRepo.findById(item.getItemId()).get();
		
		if(item.getMaterialGrpName() != null) {
			oldItemDetail.setMaterialGrpName(item.getMaterialGrpName());
		}
		if(item.getMaterial() != null) {
			oldItemDetail.setMaterial(item.getMaterial());
		}
		if(item.getItemCode() != null) {
			oldItemDetail.setItemCode(item.getItemCode());
		}
		if(item.getItemName() != null) {
			oldItemDetail.setItemName(item.getItemName());
		}
		if(item.getItemAlternateName() != null) {
			oldItemDetail.setItemAlternateName(item.getItemAlternateName());
		}
		if(item.getItemShortName() != null) {
			oldItemDetail.setItemShortName(item.getItemShortName());
		}
		if(item.getGstPercentage() != null) {
			oldItemDetail.setGstPercentage(item.getGstPercentage());
		}
		if(item.getHsnCode() != null) {
			oldItemDetail.setHsnCode(item.getHsnCode());
		}
		if(item.getPrice() != null) {
			oldItemDetail.setPrice(item.getPrice());
		}
		
		itemRepo.save(oldItemDetail);
		return ResponseEntity.ok(oldItemDetail);
	}
	
	
	
}
