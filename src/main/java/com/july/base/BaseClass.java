package com.july.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	WebDriver driver;
	
	public WebDriver initDriver() throws IOException {
		System.setProperty("WebDriver.ChromeDriver", "/Users/yogi/Java/July/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		Properties prop = new Properties();
		String path = "/Users/yogi/Java/July/src/main/java/com/july/config/config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String url = prop.getProperty("url");
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
}
