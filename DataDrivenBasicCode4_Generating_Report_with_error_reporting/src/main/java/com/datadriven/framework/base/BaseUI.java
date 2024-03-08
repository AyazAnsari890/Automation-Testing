package com.datadriven.framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.datadriven.framework.utils.DateUtils;
import com.datadriven.framework.utils.ExtentReportManager;

public class BaseUI {
	
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;


	/****************** Invoke Browser ***********************/
	//public void invokeBrowser(String browserName) 
	public void invokeBrowser(){
	
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
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
						+ "\\src\\test\\resource\\ObjectRepository\\projectConfig.properties");
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
	public void enterText(String xpathKey, String data) 
	{
			getElement(xpathKey).sendKeys(data);
			//driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
	}
	
	/****************** Click Element ***********************/
	public void elementClick(String xpathbtn) 
	{
			getElement(xpathbtn).click();
			//driver.findElement(By.xpath(prop.getProperty(xpathbtn))).click();
	}
	
	/****************** Identify Element ***********************/
	public WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
			try {

			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				
			} //It is important to use exception handling b'coz if we work on 100 cases then 20 will fail on NUll pointer so it's imp
			//to use exception handling
			else {
				reportFail("Failing the Testcase, Invalid Locator " + locatorKey);
				Assert.fail("Failing the Testcase, Invalid Locator " + locatorKey);
			
			}
			}
			catch (Exception e) {
				// Fail the TestCase and Report the error
				reportFail(e.getMessage());
				e.printStackTrace(); //Prints the complete message over here
				
				//Mark the test case as a failure
				Assert.fail("Failing the testcase: "+e.getMessage());
				
			}

		return element;

	}
	
	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		
	}

	public void reportPass(String reportString) {
		
	}
	
	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		/*
		//Typecast the driver
		//TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		//Capture the screenshot
		//File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		//The file is stored in binary format so to convert it into image form we use the destination file with image extension .png
		//File destFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");
		
		//Fileutils use apache common io dependency
				try {
					FileUtils.copyFile(sourceFile, destFile);
					logger.addScreenCaptureFromPath(
							System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");

				} catch (IOException e) {
					e.printStackTrace();
				}
				*/
		// Take screenshot
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

        // Define destination file path
        String destinationFilePath = System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.getTimeStamp() + ".png";
        File destFile = new File(destinationFilePath);
        
        try {
            // Copy screenshot to destination file
            FileUtils.copyFile(sourceFile, destFile);
            System.out.println("Screenshot captured successfully.");
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            e.printStackTrace();
        }
		
		//Fileutils use apache common io dependency
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
