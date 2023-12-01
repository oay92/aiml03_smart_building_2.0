package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aiml03.project.model.bean.Plate;
import com.aiml03.project.model.bean.Person;

public class PlateDAO 
{
	private Connection conn;

	public PlateDAO(Connection conn) 
	{
		super();
		this.conn = conn;
	}
	
	public List<Plate> getNumberPlateByBuildingNumAndUnitNum(String buildingNum, String unitNum) throws SQLException
	{
		final String SQL = "SELECT * FROM aiml03.number_plate WHERE building_num = ? AND unit_num = ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		List<Plate> plateList = new ArrayList<Plate>();
		while(rs.next())
		{
			int nID = rs.getInt("nID");
			String numberPlate = rs.getString("number_plate");
			
			Plate plate = new Plate(nID, buildingNum, unitNum, numberPlate, 1);
			plateList.add(plate);
		}
		
		rs.close();
		preState.close();
				
		return plateList;
	}
	
	public boolean isNumberPlateExistByBuildingNumAndUnitNum(String buildingNum, String unitNum) throws SQLException
	{
		boolean found = false;
		final String SQL = "SELECT * FROM aiml03.number_plate WHERE building_num = ? AND unit_num = ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		if(rs.next())
		{
			found = true;
		}
		
		rs.close();
		preState.close();		
		
		return found;
	}
	
	
	public void deleteNumberPlateByID(int nID) throws SQLException
	{
		final String SQL = "UPDATE aiml03.number_plate SET enabled = 0 WHERE nID = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setInt(1, nID);
		preState.executeUpdate();
		
		preState.close();
	}
	
	public void insertNumberPlate(String buildingNum, String unitNum, String numberPlate) throws SQLException
	{
		final String SQL = "INSERT INTO aiml03.number_plate (building_num, unit_num, number_plate) VALUES(?, ?, ?)";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		preState.setString(3, numberPlate);
		preState.executeUpdate();
		preState.close();
	}
}
