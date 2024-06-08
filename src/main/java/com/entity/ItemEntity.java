package com.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item_details")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	private String materialGrpName;
	
	@ManyToOne
	@JoinColumn(name="materialId")
	MaterialEntity material;
	
	private String itemCode;
	private String itemName;
	private String itemAlternateName;
	private String itemShortName;
	private Integer gstPercentage;
	private Integer hsnCode;
	private Integer price;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	List<PackageEntity> packages;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getMaterialGrpName() {
		return materialGrpName;
	}

	public void setMaterialGrpName(String materialGrpName) {
		this.materialGrpName = materialGrpName;
	}

	public MaterialEntity getMaterial() {
		return material;
	}

	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemAlternateName() {
		return itemAlternateName;
	}

	public void setItemAlternateName(String itemAlternateName) {
		this.itemAlternateName = itemAlternateName;
	}

	public String getItemShortName() {
		return itemShortName;
	}

	public void setItemShortName(String itemShortName) {
		this.itemShortName = itemShortName;
	}

	public Integer getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(Integer gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public Integer getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(Integer hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<PackageEntity> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageEntity> packages) {
		this.packages = packages;
	}
	
		
	
	
}
