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
	
	public List<Plate> getNumberPlateRecognitionHistory() throws SQLException
	{
		final String SQL = "select t2.building_num, t2.unit_num, t2.number_plate, t1.nID, t1.photo, t1.log_date, t1.log_time from (select * from aiml03.number_plate_recognition_log) t1 left join (select * from aiml03.number_plate where enabled = 1) t2 on t1.nID = t2.nID order by log_date desc, log_time desc;";
		PreparedStatement preState = conn.prepareStatement(SQL);

		ResultSet rs = preState.executeQuery();
		
		List<Plate> historyList = new ArrayList<Plate>();
		while(rs.next())
		{
			int nID = rs.getInt("nID");
			String buildingNum = rs.getString("building_num");
			String unitNum = rs.getString("unit_num");
			String numberPlate = rs.getString("number_plate");
			String photo = rs.getString("photo");
			String logDate = rs.getString("log_date");
			String logTime = rs.getString("log_time");
			
			Plate plate = new Plate(nID, buildingNum, unitNum, numberPlate, 1, photo, logDate, logTime);
			historyList.add(plate);
		}
		
		rs.close();
		preState.close();
				
		return historyList;
	}
	
	public List<Plate> getNumberPlateRecognitionHistoryByBuildingNumAndUnitNum(String buildingNum, String unitNum) throws SQLException
	{
		final String SQL = "select t2.building_num, t2.unit_num, t2.number_plate, t1.nID, t1.photo, t1.log_date, t1.log_time from (select * from aiml03.number_plate_recognition_log) t1 left join (select * from aiml03.number_plate where enabled = 1) t2 on t1.nID = t2.nID where building_num = ? and unit_num = ? order by log_date desc, log_time desc;";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, buildingNum);
		preState.setString(2, unitNum);
		
		ResultSet rs = preState.executeQuery();
		
		List<Plate> historyList = new ArrayList<Plate>();
		while(rs.next())
		{
			int nID = rs.getInt("nID");
			String numberPlate = rs.getString("number_plate");
			String photo = rs.getString("photo");
			String logDate = rs.getString("log_date");
			String logTime = rs.getString("log_time");
			
			Plate plate = new Plate(nID, buildingNum, unitNum, numberPlate, 1, photo, logDate, logTime);
			historyList.add(plate);
		}
		
		rs.close();
		preState.close();
				
		return historyList;
	}	
}
