package com.datadrivenframework.test.LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
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
		enterText("usrnameTextbox_Xpath","anshulc55");
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
