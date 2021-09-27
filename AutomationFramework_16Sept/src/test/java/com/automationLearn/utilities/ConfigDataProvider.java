package com.automationLearn.utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro =  new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unable to read Config file- "+e.getMessage());
		}	
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getAppUrl()
	{
		return pro.getProperty("QaUrl");
	}
}
