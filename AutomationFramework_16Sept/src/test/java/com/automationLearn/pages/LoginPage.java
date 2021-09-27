package com.automationLearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage (WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="username") WebElement usernm;
	@FindBy(name="password") WebElement passwd;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;

	public void loginApp(String username, String password)
	{
		usernm.sendKeys(username);
		passwd.sendKeys(password);
		loginbtn.click();
	}
}
