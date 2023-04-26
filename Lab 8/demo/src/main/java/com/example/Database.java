package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "student";
	private static final String PASSWORD = "STUDENT";
	private static Connection connection = null;
	
	private Database() {}
	
	
	public static Connection getConnection() {
		if (connection == null)
		{
			createConnection();
		}
			
		return connection;
	}
	
	private static void createConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded <3"); 
		
			connection= DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Connection is sucessfull: " + connection);
			connection.setAutoCommit(false);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public static void closeConnection() { 
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			} 
		}
		else {
			System.out.println("Connection is not open");
		}
	}
}
