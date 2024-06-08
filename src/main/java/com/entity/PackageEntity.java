package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="package")
public class PackageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageId;
	private String packageName;
	private Integer packageAmount;
	private String packageType;
	
	// one to many 
	@ManyToOne
	@JoinColumn(name="rateListId")
	RateListEntity rateList;
	
	@ManyToMany
	@JoinTable(
			name="packages_items",
			joinColumns = @JoinColumn(name="packageId"),
			inverseJoinColumns = @JoinColumn(name="itemId")
	)
	List<ItemEntity> items;

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getPackageAmount() {
		return packageAmount;
	}

	public void setPackageAmount(Integer packageAmount) {
		this.packageAmount = packageAmount;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public RateListEntity getRateList() {
		return rateList;
	}

	public void setRateList(RateListEntity rateList) {
		this.rateList = rateList;
	}
	
}
