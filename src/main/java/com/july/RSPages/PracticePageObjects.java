package com.july.RSPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePageObjects {
	WebDriver driver;
	
	public PracticePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	private By alert = By.xpath("//input[@class='btn-style' and @value='Alert']");
	private By alertWithName = By.xpath("//input[@name='entername']");
	
	public WebElement alert() {
		return driver.findElement(alert);
	}
	public WebElement alertWithName() {
		return driver.findElement(alertWithName);
	}
}
