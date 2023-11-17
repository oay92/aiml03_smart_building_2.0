package com.aiml03.project.model.bean;

public class Account {

	private int aID;
	private String userID;
	private String password;
	private String level;
	private int updatePassword;
	
	public Account(int aID, String userID, String password, String level, int updatePassword) {
		super();
		this.aID = aID;
		this.userID = userID;
		this.password = password;
		this.level = level;
		this.updatePassword = updatePassword;
	}
	
	public int getaID() {
		return aID;
	}
	public void setaID(int aID) {
		this.aID = aID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getUpdatePassword() {
		return updatePassword;
	}
	public void setUpdatePassword(int updatePassword) {
		this.updatePassword = updatePassword;
	}	
}
