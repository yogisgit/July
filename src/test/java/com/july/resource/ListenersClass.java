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
	ExtentReports extent = ReportGen.genReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed!!!");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
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
