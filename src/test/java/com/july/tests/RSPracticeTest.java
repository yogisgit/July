package com.july.tests;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.july.RSPages.PracticePageObjects;
import com.july.base.BaseClass;
import com.july.resource.DataProvidersDB;
import com.july.util.ExcelUtil;

public class RSPracticeTest extends BaseClass{
	public WebDriver driver;
	Logger log = Logger.getLogger(RSPracticeTest.class);
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initDriver();
		log.info("Browser opened");
	}
	@Test(dataProvider="data-Provider", dataProviderClass=DataProvidersDB.class, priority=1, enabled=true)
	public void RSAPracticePage(String data) {
		PracticePageObjects pp = new PracticePageObjects(driver);
		pp.alertBtn().click();
		log.info("Tap on alert");
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		log.info("Accepted alert");
		
		pp.alertWithName().sendKeys(data);
		log.info("Given name to alert");
		pp.alertBtn().click();
		log.info("Tap on alert");
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	
	@Test(priority=2, enabled=true)
	public void radioBtnCheck()
	{
		PracticePageObjects pp = new PracticePageObjects(driver);
		pp.radio1().click();
		System.out.println(pp.radio1().isSelected());
		System.out.println(pp.radio1().isEnabled());
		System.out.println(pp.radio1().isDisplayed());
		
		pp.radio2().click();
		System.out.println(pp.radio2().isSelected());
		System.out.println(pp.radio2().isEnabled());
		System.out.println(pp.radio2().isDisplayed());
	}
	
	@Test(dataProvider="data-Country", dataProviderClass=DataProvidersDB.class, priority=3, enabled=true)
	public void dropDownSugg(String data) {
		
		PracticePageObjects pp = new PracticePageObjects(driver);
		pp.suggistiveDropDown().sendKeys(data);
		List<WebElement> countries = pp.countries();
		
		for(WebElement country: countries) {
			if(country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}
		
		//to verify the entered values in text box
		String count = pp.suggistiveDropDown().getAttribute("value");
		System.out.println(count);
		log.info(pp.suggistiveDropDown().getAttribute("value"));
	
	}
	
	@Test(priority=4, enabled=true)
	public void staticDropDown() {
		PracticePageObjects pp = new PracticePageObjects(driver);
		WebElement dropDown = pp.staticDropDown();
		
		Select select = new Select(dropDown);
		select.selectByIndex(1);
		log.info(dropDown.getAttribute("value"));
		
		select.selectByValue("option2");
		log.info(dropDown.getAttribute("value"));
		
		select.selectByVisibleText("option3");
		log.info(dropDown.getAttribute("value"));
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
