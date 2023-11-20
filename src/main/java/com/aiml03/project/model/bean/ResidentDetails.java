package com.aiml03.project.model.bean;

public class ResidentDetails {

	private String buildingNo;
	private String unitNo;
	private String name;
	private String phoneNo;
	private String email;
	private String faceStamp;
	private String licenseStamp;
	private String resident;
	private int pID;
	private String photo;


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getpID() {
		return pID;
	}
	
	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaceStamp() {
		return faceStamp;
	}

	public void setFaceStamp(String faceStamp) {
		this.faceStamp = faceStamp;
	}

	public String getLicenseStamp() {
		return licenseStamp;
	}

	public void setLicenseStamp(String licenseStamp) {
		this.licenseStamp = licenseStamp;
	}

	@Override
	public String toString() {
		String rd = resident == null ? "null" : resident.toString();

		return "Residence details: [Resident ID:" + pID + ", buildingNo=" + buildingNo + ", unitNo=" + unitNo
				+ ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + ", faceStamp=" + faceStamp
				+ ", licenseStamp=" + licenseStamp + ", ResidentDetails=" + rd + "]";
	}

}
