package com.automationLearn.pages;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeSuite;

import com.automationLearn.utilities.BrowserFactory;
import com.automationLearn.utilities.ConfigDataProvider;
import com.automationLearn.utilities.ExcelDataProvider;
import com.automationLearn.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


//Base class.


public class BaseClass {

	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	 @BeforeSuite
	public void setup()
	{
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
		//System.out.println("BaseClass Constructor");
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/AutoLearn_"+Helper.getCurrentDateTime()+".html")); //System.getProperty("user.dir") return current project dir path 
		report = new ExtentReports();
		report.attachReporter(extent);
	}
    
	
	@BeforeClass
	public void launchApp() {	
		//System.out.println("Login Test before.");
		driver = BrowserFactory.launchBrowser(driver, config.getBrowser(), config.getAppUrl());
	
	}
	
	@AfterClass
	public void closeApp() {
		//System.out.println("Login Test after.");
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);          // On Test failure, ex wrong locator passed 
		    logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());  
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	  
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skip", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		 // else if logger.pass(details, provider);
		  //  logger.skip(details, provider);
		
		report.flush();
	}
	
	
	
}
