package com.amdocs.dao;
import java.util.*;

import com.amdocs.exception.PlantNotFoundException;
import com.amdocs.pojos.*;


public class PlantDAOImpl implements PlantDAO{
	List<Plant> plantList=new ArrayList<>();
	
	public int addPlant(Plant plant){
		if(plantList.size()==0){
			plantList.add(plant);
			return plant.getPlantId();
		}
		for(Plant p:plantList){
			if(p.getPlantId()==plant.getPlantId()){
				return 0;
			}else{
				plantList.add(plant);
				break;
			}
		}
		
		return plant.getPlantId();
	}
	
	public int deletePlant(int plantId){
		boolean y = true;
		// TODO Auto-generated method stub
		Iterator<Plant>itr = plantList.iterator();
		while(itr.hasNext()) {
			if(itr.next().getPlantId()==plantId)
			{
				y=false;
				itr.remove();
			}
		}
		if(y){
			return 0;
		}
		return plantId;
	}
	public boolean updatePlantCost(int plantId, double cost){
		for(Plant plant:plantList)
		{
			if(plant.getPlantId()==plantId)
			{				
				int indexof=plantList.indexOf(plant);
				plant.setCost(cost);
				plantList.set(indexof, plant);
				return true;
			}			
		}
		return false;
	}
	
	
	public List<Plant> showAllPlants() {
		return plantList;
	}
	
	public List<Plant> searchByOriginCountryName(String origincountryName){
		List<Plant> planttempList=new ArrayList<>();
		for(Plant plant : plantList){
			if(plant.getoriginCountryName().equalsIgnoreCase(origincountryName)){
				planttempList.add(plant);
			}
		}
		return planttempList;
	}
	
	public List<Plant> searchByOutdoorPlantsWithSunlight(){
		List<Plant> planttempList = new ArrayList<>();
		for(Plant plant : plantList) {
			if(plant.getplantType().equalsIgnoreCase("Outdoor") && plant.getSunlightRequired()){
				planttempList.add(plant);
			}
		}
		return planttempList;
	}
	
	public int countPlantsByWaterSupplyFrequency(String waterSupplyFrequency){
		List<Plant> planttempList = new ArrayList<>();
		for(Plant plant : plantList){
			if(plant.getWaterSupplyFrequency().equalsIgnoreCase(waterSupplyFrequency)){
				planttempList.add(plant);
			}
		}
		return planttempList.size();
	}

}
