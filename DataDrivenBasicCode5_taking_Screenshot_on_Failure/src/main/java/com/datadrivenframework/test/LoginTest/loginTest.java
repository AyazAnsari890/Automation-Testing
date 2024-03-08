package com.datadrivenframework.test.LoginTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.datadriven.framework.base.BaseUI;

public class loginTest extends BaseUI
{
	
	
	@Test
	public void testOne()
	{
		logger = report.createTest("Login Rediff dashboard");
		
		invokeBrowser();
		openURL("websiteURL");
		elementClick("singinBtn_Xpath");
		enterText("usrnameTextbox_Id","anshulc55");
		enterText("passwordTextbox_CSS", "passwordText");
		driver.quit();
		
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