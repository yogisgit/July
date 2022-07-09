package com.july.tests;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.july.base.BaseClass;

public class Practice extends BaseClass{
	
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initDriver();
	}
	@Test
	public void google() {
		
		List<WebElement> ele = driver.findElements(By.xpath("//a[@class='top-site-button']/descendant::div[@class='title']/span"));
	
	}
	
}
