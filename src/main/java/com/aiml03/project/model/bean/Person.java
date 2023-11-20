package com.aiml03.project.model.bean;

public class Person 
{
	private int pID;
	private String buildingNum;
	private String unitNum;
	private String name;
	private String email;
	private String phone;
	private String photo;
	private int primaryContact;
	private int enabled;
	
	public Person(int pID, String buildingNum, String unitNum, String name, String email, String phone, String photo,
			int primaryContact, int enabled) {
		super();
		this.pID = pID;
		this.buildingNum = buildingNum;
		this.unitNum = unitNum;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
		this.primaryContact = primaryContact;
		this.enabled = enabled;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getBuildingNum() {
		return buildingNum;
	}
	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}
	public String getUnitNum() {
		return unitNum;
	}
	public void setUnitNum(String unitNum) {
		this.unitNum = unitNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(int primaryContact) {
		this.primaryContact = primaryContact;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}



}
