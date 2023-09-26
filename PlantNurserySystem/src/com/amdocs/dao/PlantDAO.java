package com.amdocs.dao;

import java.util.*;


import com.amdocs.exception.PlantNotFoundException;
import com.amdocs.pojos.Plant;

public interface PlantDAO {
	
	int addPlant(Plant plant);
	int deletePlant(int plantId)throws PlantNotFoundException;
	boolean updatePlantCost(int plantId,double cost)throws PlantNotFoundException;
	List<Plant> showAllPlants();
	List<Plant> searchByOriginCountryName(String origincountryName)throws PlantNotFoundException;
	List<Plant> searchByOutdoorPlantsWithSunlight()throws PlantNotFoundException;
	int countPlantsByWaterSupplyFrequency(String waterSupplyFrequency);
	
	
	

}
