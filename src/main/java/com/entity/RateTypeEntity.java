package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ratetype")
public class RateTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rateTypeId;
	private String rateTypeName;
	
	public Integer getRateTypeId() {
		return rateTypeId;
	}
	public void setRateTypeId(Integer rateTypeId) {
		this.rateTypeId = rateTypeId;
	}
	public String getRateTypeName() {
		return rateTypeName;
	}
	public void setRateTypeName(String rateTypeName) {
		this.rateTypeName = rateTypeName;
	}
		
}
