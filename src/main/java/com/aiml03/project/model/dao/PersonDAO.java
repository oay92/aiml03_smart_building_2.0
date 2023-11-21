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
}
