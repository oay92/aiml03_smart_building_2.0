package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aiml03.project.model.bean.Person;

public class PersonDAO {

	private Connection conn;

	public PersonDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public void insertPerson(Person person) throws SQLException {
		final String SQL = "INSERT INTO person(build_num, unit_num, name, email, phone, primary_contact)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, person.getBuilding_num());
		preState.setInt(2, person.getUnit_num());
		preState.setString(3, person.getName());
		preState.setString(4, person.getEmail());
		preState.setString(5, person.getPhone());
		preState.setInt(6, person.getPrimary_contact());
		//preState.setString(7, person.getLicense_plate());

		preState.executeUpdate();
	}
}
