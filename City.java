package application;

import java.util.ArrayList;
public class City {
	public String cityName;
	public int cellId;
	public int cityId;
	public ArrayList<Passenger> passengers;
	public ArrayList<Passenger> arrivals;
	
	public City(String cityName,int cellId,int cityId) {
		this.cityName = cityName;
		this.cellId = cellId;
		this.cityId = cityId;
	}
	
	public void addPassenger(Passenger passenger) {
		
		
			
	}
	
	public void getInfo() {
		System.out.println("INFORMATION PLACE");
	}
	
}