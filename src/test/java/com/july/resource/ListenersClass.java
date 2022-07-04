package com.july.resource;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.july.reports.ReportGen;
import com.july.util.ScreenshotCap;

public class ListenersClass implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		ReportGen rg = new ReportGen();
		extent = rg.genReport();
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Passed!!!");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Failed!!!");
		test.fail(result.getThrowable());
		
		ScreenshotCap ss = new ScreenshotCap();
		WebDriver driver=null;
		String methodName = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String path = ss.takeScreenshot(driver, methodName);
			test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
