package com.Selenium.masterpart2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropDown {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
	
    @Test
    public void DropDown()
    {
    	driver.get("https://www.facebook.com/signup");
    	WebElement monthDropDown = driver.findElement(By.name("birthday_month"));
    	Select select = new Select(monthDropDown);
    	
    	//To select the month through their index
    	select.selectByIndex(5);
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//To select the month with values associated with them like May is the 5th month of the year
    	select.selectByValue("5");
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//To select the option by their name showing in the DropDown
    	select.selectByVisibleText("Jan");
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  
    	// To print all the options present in Month DropDown
    	List<WebElement> monthValues = select.getOptions();
    	for(WebElement i: monthValues) 
    	{
    	System.out.println(i.getText());
    	}
    	
    	
    }
    
}

