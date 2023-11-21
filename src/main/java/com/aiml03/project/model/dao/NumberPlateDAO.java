package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aiml03.project.model.bean.NumberPlate;
import com.aiml03.project.model.bean.Person;

public class NumberPlateDAO 
{
	private Connection conn;

	public NumberPlateDAO(Connection conn) 
	{
		super();
		this.conn = conn;
	}
	
	public List<NumberPlate> getNumberPlateByBuildingNumAndUnitNum(String buildingNum, String unitNum) throws SQLException
	{
		final String SQL = "SELECT * FROM aiml03.number_plate WHERE building_num = ? AND unit_num = ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		List<NumberPlate> plateList = new ArrayList<NumberPlate>();
		while(rs.next())
		{
			int nID = rs.getInt("nID");
			String numberPlate = rs.getString("number_plate");
			
			NumberPlate plate = new NumberPlate(nID, buildingNum, unitNum, numberPlate, 1);
			plateList.add(plate);
		}
		
		rs.close();
		preState.close();
				
		return plateList;
	}
}
