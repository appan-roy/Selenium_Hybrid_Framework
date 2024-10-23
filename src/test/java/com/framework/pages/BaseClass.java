package com.framework.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utility.BrowserFactory;
import com.framework.utility.ConfigDataProvider;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void suite_setup(){
		
		Reporter.log("Setting up test suite", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/OrangeHRM_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();		
		report.attachReporter(extent);
		
		Reporter.log("Settings are done - Test can be started", true);
		
	}
	
//	THIS IS WITHOUT MAVEN PARAMETER PASS
//	@BeforeClass
//	public void test_setup(){
//		
//		Reporter.log("Trying to start browser and getting application ready", true);
//		
//		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
//		
//		Reporter.log("Application is up and running", true);
//		
//	}
	
//	THIS IS WITH MAVEN PARAMETER PASS
	@Parameters({"browser", "testURL"})
	@BeforeClass
	public void test_setup(String browser, String url){
		
		Reporter.log("Trying to start browser and getting application ready", true);
		
		driver = BrowserFactory.startApplication(driver, browser, url);
		
		Reporter.log("Application is up and running", true);
		
	}
	
	@AfterClass
	public void test_teardown(){
		
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException{
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		if(result.getStatus()==ITestResult.SUCCESS){
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}

		report.flush();
		
		Reporter.log("Test is completed and reports are published", true);
		
	}

}
