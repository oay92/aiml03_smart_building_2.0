package com.aiml03.project.model.bean;

public class Person {
	private int pID;
	private String building_num;
	private int unit_num;
	private String name;
	private String email;
	private String phone;
	private byte[] photo;
	private int primary_contact;
	private int enabled;

	public Person(int pID, String building_num, int unit_num, String name, String email, String phone, byte[] photo,
			int primary_contact, int enabled) {
		super();
		this.pID = pID;
		this.building_num = building_num;
		this.unit_num = unit_num;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
		this.primary_contact = primary_contact;
		this.enabled = enabled;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getPrimary_contact() {
		return primary_contact;
	}

	public void setPrimary_contact(int primary_contact) {
		this.primary_contact = primary_contact;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
