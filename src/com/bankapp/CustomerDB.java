package com.bankapp;
import java.sql.Connection;
import java.sql.DriverManager;
public class CustomerDB {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/bankcustomer";
		String userName = "postgres";
		String password = "0000";
		
		Connection connection;
		
		try
		{
			connection = DriverManager.getConnection(url, userName, password);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}