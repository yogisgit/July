package com.july.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCap {
	public String takeScreenshot(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = "/Users/yogi/Java/July/screenshots/"+methodName+".jpg";
		FileUtils.copyFile(src, new File(dest));
		
		return dest;
	}
}
