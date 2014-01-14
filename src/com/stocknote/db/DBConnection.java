package com.stocknote.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	//DB Connection info
	public static String JDBC_URL = "jdbc:mysql://localhost:3306/stock?useUnicode=true&characterEncoding=UTF-8";
//	public static String JDBC_URL = "jdbc:mysql://192.168.219.163:3306/stock?useUnicode=true&characterEncoding=UTF-8";
	public static String JDBC_USER_ID = "root";
	public static String JDBC_USER_PASSWORD = "";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER_ID, JDBC_USER_PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
