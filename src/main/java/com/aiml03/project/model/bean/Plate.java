package com.aiml03.project.model.bean;

import com.aiml03.project.util.DataFormat;

public class Plate 
{
	private int nID;
	private String buildingNum;
	private String unitNum;
	private String numberPlate;
	private int enabled;
	private DataFormat format = new DataFormat();
	
	public Plate(int nID, String buildingNum, String unitNum, String numberPlate, int enabled) {
		super();
		this.nID = nID;
		this.buildingNum = buildingNum;
		this.unitNum = unitNum;
		this.numberPlate = numberPlate;
		this.enabled = enabled;
	}
	public int getnID() {
		return nID;
	}
	public void setnID(int nID) {
		this.nID = nID;
	}
	public String getBuildingNum() {
		return format.formatString(buildingNum);
	}
	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}
	public String getUnitNum() {
		return format.formatString(unitNum);
	}
	public void setUnitNum(String unitNum) {
		this.unitNum = unitNum;
	}
	public String getNumberPlate() {
		return format.formatString(numberPlate);
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
