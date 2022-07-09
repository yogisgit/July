package com.july.RSPages;

import java.util.List;

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
	
	private By radio1 = By.xpath("//input[@name='radioButton' and @value='radio1']");
	private By radio2 = By.xpath("//input[@name='radioButton' and @value='radio2']");
	
	private By suggistiveDropDown = By.xpath("//input[@id='autocomplete']");
	private By countries = By.xpath("//div[@class='ui-menu-item-wrapper']");
	
	private By staticDropDown = By.xpath("//select[@id='dropdown-class-example']");
	
	public WebElement alertBtn() {
		return driver.findElement(alert);
	}
	public WebElement alertWithName() {
		return driver.findElement(alertWithName);
	}
	public WebElement radio1() {
		return driver.findElement(radio1);
	}
	public WebElement radio2() {
		return driver.findElement(radio2);
	}
	public WebElement suggistiveDropDown() {
		return driver.findElement(suggistiveDropDown);
	}
	public List<WebElement> countries() {
		return driver.findElements(countries);
	}
	public WebElement staticDropDown() {
		return driver.findElement(staticDropDown);
	}
}
