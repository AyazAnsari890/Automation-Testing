package com.datadriven.framework.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.datadriven.framework.utils.ExtentReportManager;

public class BaseUI {
	
	public static WebDriver driver;
	public static Properties prop;


	/****************** Invoke Browser ***********************/
	//public void invokeBrowser(String browserName) 
	public void invokeBrowser(){
		

	
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			/*
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozila")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/operadriver");
				driver = new OperaDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/IEDriverServer.exe");
				driver = new OperaDriver();
			} else {
				driver = new SafariDriver();
			}
			*/
	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		

		// System.out.println(System.getProperty("user.dir"));

		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\ObjectRepository\\projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				//reportFail(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	/****************** Open URL ***********************/
	public void openURL(String websiteURLKey) {
			driver.get(prop.getProperty(websiteURLKey));

	}

	/****************** Close Browser ***********************/
	public void tearDown() {
		driver.close();

	}

	/****************** Quit Browser ***********************/
	public void quitBrowser() {
		driver.quit();

	}
	
	/****************** Enter Text ***********************/
	public void enterText(String xpathKey, String data) {
		
			driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
	}
	
	/****************** Click Element ***********************/
	public void elementClick(String xpathbtn) {

			driver.findElement(By.xpath(prop.getProperty(xpathbtn))).click();

}
}
