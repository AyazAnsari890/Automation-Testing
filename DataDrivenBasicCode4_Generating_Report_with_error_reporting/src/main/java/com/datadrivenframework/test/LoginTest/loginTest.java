package com.datadrivenframework.test.LoginTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.datadriven.framework.base.BaseUI;


public class loginTest extends BaseUI
{
	
	
	@Test
	public void testOne()
	{
		logger = report.createTest("Test One");
		
		logger.log(Status.INFO, "Initializing the Browser");
		invokeBrowser();
		
		logger.log(Status.INFO, "Opening the URL");
		openURL("websiteURL");
		
		logger.log(Status.INFO, "Click on Sign In Button");
		elementClick("singinBtn_Xpath");
		
		logger.log(Status.INFO, "Entering the username");
		enterText("usrnameTextbox_Id","anshulc55");
		
		logger.log(Status.INFO, "Entering the password");
		enterText("passwordTextbox_CSS", "passwordText");
		
		//logger.log(Status.PASS, "Test executed successfully");
		logger.log(Status.FAIL, "Test Execution Failed");
		quitBrowser();
		
		//Take the screenshot
		takeScreenShotOnFailure();
		
	}
	
	@AfterTest
	public void endReport()
	{
		report.flush();
	}
	
	//@Test(dependsOnMethods="testOne")
	public void testTwo()
	{
		
	}
	
	//@Test
	public void testThree()
	{
		
	}
}