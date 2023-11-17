package com.aiml03.project.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactory {
	/**
	 * 使用JNDI尋找DataSource，取得連線物件後回傳
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() throws Exception {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		Connection conn = ds.getConnection();

		return conn;
	}
}
