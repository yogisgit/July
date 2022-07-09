package com.july.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DataBase {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public void dbConn() throws SQLException {
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Testing", "root", "Password");

	}
	public void dbClose() throws SQLException {
		con.close();
	}
	public String countryData() throws SQLException {
		dbConn();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select name from Country");
		String name = null;

		while (rs.next()) {
			name = rs.getString("name");
		}
		dbClose();
		return name;
	}
	
	

}
