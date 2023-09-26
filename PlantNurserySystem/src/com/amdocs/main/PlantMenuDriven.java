package com.amdocs.main;
import java.util.*;

import com.amdocs.dao.*;
import com.amdocs.exception.PlantNotFoundException;
import com.amdocs.pojos.*;

public class PlantMenuDriven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		PlantDAOImpl dao=new PlantDAOImpl(); 
		do {
			
			System.out.println("1. Add new Plant\r\n"
					+ "2. Update Plant Cost\r\n"
					+ "3. Delete Plant\r\n"
					+ "4. View all Plants\r\n"
					+ "5. Find plant by origin country name\r\n"
					+ "6. Find outdoor plant which requires sunlight\r\n"
					+ "7. Count plants by water supply frequency\r\n"
					+ "8. Exit\r\n"
					+ "");
			
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
			System.out.println("Enter Plant Id");
			int plantId=sc.nextInt();
			System.out.println("Enter plantName");
			String plantName=sc.next();
			System.out.println("Enter origin country of the plant");
			String origincountry=sc.next();
			System.out.println("Enter if the plant requires sunlight");
			boolean sunlightRequired=sc.nextBoolean();
			System.out.println("Enter the water supply frequency of the plant");
			String waterSupplyFrequency=sc.next();
			System.out.println("Enter the plant type whether indoor or outdoor");
			String plantType=sc.next();
			System.out.println("enter the cost of the plant");
			double cost = sc.nextDouble();
			Plant plant=new Plant(plantId,plantName,origincountry,sunlightRequired,waterSupplyFrequency,plantType,cost);
			int y = 0;
			try{
				y = dao.addPlant(plant);
				if(y!=0)
					System.out.println("Plant added Successfully");
				else
					throw new PlantNotFoundException("Plant with same id already exists");
			} catch(PlantNotFoundException e){
				e.printStackTrace();
			}
			
			
			
			break;
			
			case 2:
				System.out.println("Update Plant Cost");
				System.out.println("Enter the plant Id");
				int plantId2=sc.nextInt();
				System.out.println("Enter the updated cost");
				double cost2=sc.nextDouble();
				 boolean flag=false;
					try {
						flag = dao.updatePlantCost(plantId2, cost2);
						 if(flag)
							 System.out.println("Plant Cost Updated");
						 else
							 throw new PlantNotFoundException("Plant Not Found");
					} catch (PlantNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			
			case 3:
				System.out.println("Enter the plant id you want to delete");
				int iddelete = sc.nextInt();
				int x = 0;
				
				try{
					x = dao.deletePlant(iddelete);
					if(x!=0){
						System.out.println("Doctor has been deleted");
					}else
						throw new PlantNotFoundException("Doctor Not Found");
				} catch (PlantNotFoundException e){
					e.printStackTrace();
				}
				
				
				break;
				
			case 4:
				System.out.println("View All Planst");
				List<Plant> plantList=dao.showAllPlants();
				if(plantList.size()>0){
					for(Plant doc:plantList) {
						System.out.println(doc);
					}
				}else{
					System.out.println("No Plants are currently available");
				}
				break;
				
			case 5:
				System.out.println("Enter the country origin for which you want plants to be shown");
				String sp = sc.next(); 
				try{
					List<Plant>planttemp = dao.searchByOriginCountryName(sp);
					if(planttemp.size()>0){
						for(Plant doc:planttemp) {
							System.out.println(doc);
						}
						System.out.println("Above is the List");
						
					}else{
						throw new PlantNotFoundException("No Plant availabe for the desired country origin");
					}
				}catch (PlantNotFoundException e){
					e.printStackTrace();
				}
				
				break;
				
			case 6:
				System.out.println("finding outdoor plants which requires sunlight......");
				
				try{
					List<Plant>planttemp = dao.searchByOutdoorPlantsWithSunlight();
					if(planttemp.size()>0){
						for(Plant doc:planttemp) {
							System.out.println(doc);
						}
						System.out.println("Above is the List");
						
					}else{
						throw new PlantNotFoundException("No outdoor plant availabe which requires sunlight");
					}
				}catch (PlantNotFoundException e){
					e.printStackTrace();
				}
				
				break;
				
			case 7:
				System.out.println("Enter the water supply frequency you want plants for");
				String waterSupply = sc.next();
				int docCount = dao.countPlantsByWaterSupplyFrequency(waterSupply);
				System.out.println("The number of doctors currently available are :"+docCount);
				break;
				
			case 8:
				System.out.println("Exiting.......");
				break;
				
			}
		}
			while(true);

	}

}
