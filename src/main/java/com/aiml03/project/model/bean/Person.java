package com.aiml03.project.model.bean;

import com.aiml03.project.util.DataFormat;

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
	
	private String logDate;
	private String logTime;
	
	private DataFormat format = new DataFormat();

	public Person() {
		super();
	}
	
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
	
	public Person(int pID, String buildingNum, String unitNum, String name, String email, String phone, String photo,
			int primaryContact, int enabled, String logDate, String logTime) {
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
		this.logDate = logDate;
		this.logTime = logTime;
	}
	
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
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
	public String getName() {
		return format.formatString(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return format.formatString(email);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return format.formatString(phone);
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return format.formatString(photo);
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

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}	
}
