package com.july.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGen {
	
	public static ExtentReports genReport() {
		String path = "/Users/yogi/Java/July/reports/extent.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Yogi");
		return extent;
	}
}
