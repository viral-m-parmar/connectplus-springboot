package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ratelist")
public class RateListEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rateListId;
	private String rateListName;
	private Integer rateListAmount;
	
	@ManyToOne
	@JoinColumn(name="rateTypeId")
	RateTypeEntity rateType;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	DepartmentEntity department;

	public Integer getRateListId() {
		return rateListId;
	}

	public void setRateListId(Integer rateListId) {
		this.rateListId = rateListId;
	}

	public String getRateListName() {
		return rateListName;
	}

	public void setRateListName(String rateListName) {
		this.rateListName = rateListName;
	}

	public Integer getRateListAmount() {
		return rateListAmount;
	}

	public void setRateListAmount(Integer rateListAmount) {
		this.rateListAmount = rateListAmount;
	}

	public RateTypeEntity getRateType() {
		return rateType;
	}

	public void setRateType(RateTypeEntity rateType) {
		this.rateType = rateType;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
	
}
