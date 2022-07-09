package com.july.resource;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;

import com.july.util.ExcelUtil;

public class DataProvidersDB {
	@DataProvider(name = "data-Provider")
	public Object[] getData() throws IOException {
		ExcelUtil eu = new ExcelUtil();
		Object[] data = eu.getData();
		return data;
	}
	
	@DataProvider(name = "data-Country")
	public Object[] getCountry() throws IOException, SQLException {
		Object[] obj = new Object[1];
		DataBase db = new DataBase();
		String country = db.countryData();
		obj[0] = country;
		return obj;
	}
}
