package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		final String SQL = "INSERT INTO aiml03.person(building_num, unit_num, name, email, phone, primary_contact) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, person.getBuildingNum());
		preState.setString(2, person.getUnitNum());
		preState.setString(3, person.getName());
		preState.setString(4, person.getEmail());
		preState.setString(5, person.getPhone());
		preState.setInt(6, person.getPrimaryContact());
		preState.executeUpdate();
	}
}
