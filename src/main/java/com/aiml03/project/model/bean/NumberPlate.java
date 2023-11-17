package com.aiml03.project.model.bean;

public class NumberPlate {
	private int nID;
	private String building_num;
	private int unit_num;
	private String name;
	private String number_plate;

	public NumberPlate(int nID, String building_num, int unit_num, String name, String number_plate) {
		super();
		this.nID = nID;
		this.building_num = building_num;
		this.unit_num = unit_num;
		this.name = name;
		this.number_plate = number_plate;

	}
	
	public int getnID() {
		return nID;
	}
	public void setnID(int nID) {
		this.nID = nID;
	}
	public String getBuilding_num() {
		return building_num;
	}
	public void setBuilding_num(String building_num) {
		this.building_num = building_num;
	}
	public int getUnit_num() {
		return unit_num;
	}
	public void setUnit_num(int unit_num) {
		this.unit_num = unit_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber_plate() {
		return number_plate;
	}
	public void setNumber_plate(String number_plate) {
		this.number_plate = number_plate;
	}

	public NumberPlate() {
	    
    }

}
