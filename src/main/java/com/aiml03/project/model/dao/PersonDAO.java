package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aiml03.project.model.bean.Person;

public class PersonDAO 
{

	private Connection conn;

	public PersonDAO(Connection conn) 
	{
		super();
		this.conn = conn;
	}

	public void insertPerson(Person person) throws SQLException 
	{
		final String SQL = "INSERT INTO aiml03.person(building_num, unit_num, name, email, phone, photo, primary_contact) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, person.getBuildingNum());
		preState.setString(2, person.getUnitNum());
		preState.setString(3, person.getName());
		preState.setString(4, person.getEmail());
		preState.setString(5, person.getPhone());
		preState.setString(6, person.getPhoto());
		preState.setInt(7, person.getPrimaryContact());
		preState.executeUpdate();
	}
	
	public void updatePersonInfoByID(Person person) throws SQLException
	{
		final String SQL = "UPDATE aiml03.person SET name = ?, email = ?, phone = ?, photo = ?, primary_contact = ? WHERE pID = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, person.getName());
		preState.setString(2, person.getEmail());
		preState.setString(3, person.getPhone());
		preState.setString(4, person.getPhoto());
		preState.setInt(5, person.getPrimaryContact());
		preState.setInt(6, person.getpID());
		preState.executeUpdate();		
	}
	
	public List<Person> getAllPersonByBuildingNumberAndUnitNumber(String buildingNum, String unitNum) throws SQLException
	{
		final String SQL = "SELECT * FROM aiml03.person WHERE building_num = ? AND unit_num = ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		List<Person> personList = new ArrayList<Person>();
		while(rs.next())
		{
			int pID = rs.getInt("pID");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String photo = rs.getString("photo");
			int primaryContact = rs.getInt("primary_contact");
			
			Person person = new Person(pID, buildingNum, unitNum, name, email, phone, photo, primaryContact, 1);
			personList.add(person);
		}
		
		rs.close();
		preState.close();
		
		return personList;
	}
	
	public Person getPersonInfoByID(int pID) throws SQLException
	{
		Person person = null;
		
		final String SQL = "SELECT * FROM aiml03.person WHERE pID= ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setInt(1, pID);
		
		ResultSet rs = preState.executeQuery();
		
		if(rs.next())
		{
			String buildingNum = rs.getString("building_num");
			String unitNum = rs.getString("unit_num");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String photo = rs.getString("photo");
			int primaryContact = rs.getInt("primary_contact");
			
			person = new Person(pID, buildingNum, unitNum, name, email, phone, photo, primaryContact, 1);
		}
		
		rs.close();
		preState.close();
		
		return person;
	}
	
	public int getLastInsertPID() throws SQLException
	{
		int pID = 0;
		
		final String SQL = "SELECT MAX(pID) AS pID FROM aiml03.person";
		PreparedStatement preState = conn.prepareStatement(SQL);
		
		ResultSet rs = preState.executeQuery();
		
		if(rs.next())
		{
			pID = rs.getInt("pID");
		}
		
		rs.close();
		preState.close();		
		
		return pID;
	}
	
	public boolean isPersonFoundByBuildingNumberAndUnitNumber(String buildingNum, String unitNum) throws SQLException
	{
		boolean found = false;
		final String SQL = "SELECT * FROM aiml03.person WHERE building_num = ? AND unit_num = ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		if (rs.next())
		{
			found = true;
		}
		
		rs.close();
		preState.close();
		
		return found;
	}
	
	public void deletePersonbyID(int pID) throws SQLException
	{
		final String SQL = "UPDATE aiml03.person SET enabled = 0 WHERE pID = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setInt(1, pID);

		preState.executeUpdate();
	}
	
	public void insertFacialFeatures(int pID, List<String> features) throws SQLException
	{
		final String SQL = "INSERT INTO aiml03.`facial_features`(`pID`, `index_num`, `feature`) VALUES (?, ?, ?)";
		PreparedStatement preState = conn.prepareStatement(SQL);
		
		int index = 0;
		for(String feature: features)
		{
			index++;
			double f = Double.parseDouble(feature);
			
			preState.setInt(1, pID);
			preState.setInt(2, index);
			preState.setDouble(3, f);
			preState.addBatch();
		}
		
		preState.executeBatch();
	}
	
	public void updateFacialFeatures(int pID, List<String> features) throws SQLException
	{
		PreparedStatement preState = null;
		
		// Delete existing records
		final String SQL1 = "DELETE FROM aiml03.`facial_features` WHERE `pID` = ?";
		preState = conn.prepareStatement(SQL1);
		preState.setInt(1, pID);
		preState.addBatch();
				
		// Insert new records		
		final String SQL2 = "INSERT INTO aiml03.`facial_features`(`pID`, `index_num`, `feature`) VALUES (?, ?, ?)";
		preState = conn.prepareStatement(SQL2);
		
		int index = 0;
		for(String feature: features)
		{
			index++;
			double f = Double.parseDouble(feature);
			
			preState.setInt(1, pID);
			preState.setInt(2, index);
			preState.setDouble(3, f);
			preState.addBatch();
		}
		
		preState.executeBatch();		
	}
	
	public List<Person> getFaceRecognitionHistory() throws SQLException
	{
		final String SQL = "select t2.pID, t2.name, t2.building_num, t2.unit_num, t1.photo, t1.log_date, t1.log_time from (select * from aiml03.face_recognition_log) t1 left join (select * from aiml03.person where enabled = 1) t2 on t1.pID = t2.pID order by log_date desc, log_time desc";
		PreparedStatement preState = conn.prepareStatement(SQL);
		
		ResultSet rs = preState.executeQuery();
		
		List<Person> historyList = new ArrayList<Person>();
		while(rs.next())
		{
			int pID = rs.getInt("pID");
			String name = rs.getString("name");
			String buildingNum = rs.getString("building_num");
			String unitNum = rs.getString("unit_num");
			String photo = rs.getString("photo");
			String logDate = rs.getString("log_date");
			String logTime = rs.getString("log_time");
			
			Person person = new Person(pID, buildingNum, unitNum, name, "", "", photo, 0, 1, logDate, logTime);
			historyList.add(person);
		}
		
		rs.close();
		preState.close();
		
		return historyList;
	}
	
	public List<Person> getFaceRecognitionHistoryByBuildingNumberAndUnitNumber(String buildingNum, String unitNum) throws SQLException
	{
		final String SQL = "select t2.pID, t2.name, t1.photo, t1.log_date, t1.log_time from (select * from aiml03.face_recognition_log) t1 left join (select * from aiml03.person where enabled = 1) t2 on t1.pID = t2.pID where building_num = ? and unit_num = ? order by log_date desc, log_time desc";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		List<Person> historyList = new ArrayList<Person>();
		while(rs.next())
		{
			int pID = rs.getInt("pID");
			String name = rs.getString("name");
			String photo = rs.getString("photo");
			String logDate = rs.getString("log_date");
			String logTime = rs.getString("log_time");
			
			Person person = new Person(pID, buildingNum, unitNum, name, "", "", photo, 0, 1, logDate, logTime);
			historyList.add(person);
		}
		
		rs.close();
		preState.close();
		
		return historyList;
	}	
}
