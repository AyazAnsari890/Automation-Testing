package com.Selenium.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Base {
	
	public static WebDriver driver = null;
	public static Properties prop = null;
	public static WebDriver wait;
	public static ExtentHtmlReporter exthtml;
	public static ExtentTest extest;
	public static ExtentReports report;
	
	/************************************ Invoke Browser ***************************************/
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Read from the config.properties file
		if (prop == null) {
			prop = new Properties();

			
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\main\\java\\Config\\config.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		//Create an HTML Report
		exthtml = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "\\Report\\ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter();
		*/
		
		
	}
	/*************************************** Open URL ************************************/
	public void openURL(String websiteURLKey) {
		try {
			driver.get(prop.getProperty(websiteURLKey));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/****************** Quit Browser ***********************/
	
	public void quitBrowser()
	{
		driver.quit();
	}

}
