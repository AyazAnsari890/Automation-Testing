package com.datadrivenframework.test.LoginTest;

import org.testng.annotations.Test;

import com.datadriven.framework.base.BaseUI;

public class loginTest extends BaseUI
{
	
	@Test
	public void testOne()
	{
		invokeBrowser();
		openURL("websiteURL");
		elementClick("singinBtn_Xpath");
		enterText("usrnameTextbox_Id","anshulc55");
		enterText("passwordTextbox_CSS", "passwordText");
		quitBrowser();
		
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