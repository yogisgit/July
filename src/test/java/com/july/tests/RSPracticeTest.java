package com.july.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.july.RSPages.PracticePageObjects;
import com.july.base.BaseClass;
import com.july.util.ExcelUtil;

public class RSPracticeTest extends BaseClass{
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
		driver = initDriver();
	}
	@Test(dataProvider="getData")
	public void RSAPracticePage(String data) {
		PracticePageObjects pp = new PracticePageObjects(driver);
		pp.alert().click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		pp.alertWithName().sendKeys(data);
		pp.alert().click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@DataProvider
	public Object[] getData() throws IOException {
		ExcelUtil eu = new ExcelUtil();
		Object[] data = eu.getData();
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}