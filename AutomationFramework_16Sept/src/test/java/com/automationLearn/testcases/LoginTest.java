package com.automationLearn.testcases;


/*import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;*/
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automationLearn.pages.BaseClass;
import com.automationLearn.pages.LoginPage;
import com.automationLearn.utilities.Helper;
//import com.automationLearn.utilities.BrowserFactory;

public class LoginTest extends BaseClass {
	
	//launch Application
	
	
	@Test(priority=1)
	public void login()
	{
		
		logger = report.createTest("Login to CRM");
		
		LoginPage lpg = PageFactory.initElements(driver, LoginPage.class);
		//logger.info("Starting Application");
		lpg.loginApp(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		
		//logger.pass("Login done successfully");
	
		//Helper.captureScreenshot(driver);  --  will not execute if test step fails so write down it in Baseclass - @afterMethod 
		
	}
	
	@Test(priority=2)
	public void login2()
	{
		
		//logger = report.createTest("Logout");
		
		//logger.fail("Logout failed");
	
		//Helper.captureScreenshot(driver);  --  will not execute if test step fails so write down it in Baseclass - @afterMethod 
		
	}
	
	 //quit Application

}
