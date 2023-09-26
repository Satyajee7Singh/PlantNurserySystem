package com.amdocs.pojos;

import java.util.*;

public class Plant{
	private int plantId;
	private String plantName;
	private String origincountryName;
	private boolean sunlightRequired;
	private String waterSupplyFrequency;
	private String plantType;
	private double cost;
	//implements Comparable<Doctor>
	
	public Plant(int plantId, String plantName, String origincountryName, boolean sunlightRequired, String waterSupplyFrequency,
			String plantType,double cost) {
		
		this.plantId = plantId;
		this.plantName = plantName;
		this.origincountryName = origincountryName;
		this.sunlightRequired = sunlightRequired;
		this.waterSupplyFrequency = waterSupplyFrequency;
		this.plantType = plantType;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantName=" + plantName + ", origincountryName=" + origincountryName
				+ ", sunlightRequired=" + sunlightRequired + ", waterSupplyFrequency=" + waterSupplyFrequency + ",plantType =" + plantType + " ,cost=" + cost + "]";
	}
	
	
	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	
	public String getPlantName() {
		return plantName;
	}
	
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	
	public String getoriginCountryName() {
		return origincountryName;
	}
	public void setOriginCountryName(String origincountryName) {
		this.origincountryName = origincountryName;
	}
	
	public boolean getSunlightRequired() {
		return sunlightRequired;
	}
	public void setSunlightRequired(boolean sunlightRequired) {
		this.sunlightRequired = sunlightRequired;
	}
	
	public String getWaterSupplyFrequency() {
		return waterSupplyFrequency;
	}
	public void setWaterSupplyFrequency(String waterSupplyFrequency) {
		this.waterSupplyFrequency= waterSupplyFrequency;
	}
	
	public String getplantType() {
		return plantType;
	}
	public void setplantType(String plantType) {
		this.plantType = plantType;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
	
	
	
	

	
}
