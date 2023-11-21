package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aiml03.project.model.bean.Account;

public class AccountDAO {
	private Connection conn;

	public AccountDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public Account findAccountByUserIDAndPassword(String userID, String password) throws SQLException
	{
		final String SQL = "SELECT * FROM aiml03.account WHERE BINARY user_id = ? AND BINARY password = ? AND enabled = 1";		
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, userID);
		preState.setString(2, password);		
		
		ResultSet rs = preState.executeQuery();
		
		Account account = null;
		if (rs.next())
		{
			int aID = rs.getInt("aID");
			String level = rs.getString("level");
			int updatePassword = rs.getInt("update_password");
			
			account = new Account(aID, userID, password, level, updatePassword);
		}
		
		rs.close();
		preState.close();
		
		return account;
	}
	
	public boolean isAccountExist(String userID) throws SQLException
	{
		boolean found = false;
		final String SQL = "SELECT * FROM aiml03.account WHERE BINARY user_id = ? AND enabled = 1";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, userID);
		
		ResultSet rs = preState.executeQuery();
		
		if (rs.next())
		{
			found = true;
		}
		
		rs.close();
		preState.close();		
		
		return found;
	}
	
	public void insertAccountInfo(String userID, String password, String level) throws SQLException
	{
		final String SQL = "INSERT INTO aiml03.account (user_id, password, level) VALUES (?, ?, ?)";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, userID);
		preState.setString(2, password);
		preState.setString(3, level);
		preState.executeUpdate();
		
		preState.close();
	}
	
	public void updatePassword(String password, int aID) throws SQLException
	{
		final String SQL = "UPDATE aiml03.account SET password = ?, update_password = 0 WHERE aID = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, password);
		preState.setInt(2, aID);
		preState.executeUpdate();
		
		preState.close();		
	}
}
