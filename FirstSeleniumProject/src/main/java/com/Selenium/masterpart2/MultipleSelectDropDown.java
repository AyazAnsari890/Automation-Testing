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

public class MultipleSelectDropDown {
	
WebDriver driver = null;
	
	@BeforeMethod
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
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
		public void MultipleDrop()
		{
	      //URL launch
	      driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
	      
	      //Identify the dropdown and assign the locator to a variable
	      WebElement d = driver.findElement(By.xpath("//select[@name='selenium_commands']"));

	      //Create Object of Select class
	      Select select = new Select(d);
	      
	      //get options of dropdown in list
	      List<WebElement> t =select.getOptions();
	      System.out.println("Options are: ");
	      for (WebElement i: t){ //(for int i=0;i<5;i++
	         System.out.println(i.getText());
	      }
	      
	      //Return true if multi-select dropdown
	      Boolean b = select.isMultiple();

	      System.out.println("Boolen value for drodown: "+ b);
	      
	      //Select the item by index
	      select.selectByIndex(2);
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //select item by visible text
	      select.selectByVisibleText("Wait Commands");
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      //get first selected option in dropdown
	      WebElement f = select.getFirstSelectedOption();
	      System.out.println("First selected option is: "+ f.getText());
	      
	      //deselect option by index
	      select.deselectByIndex(2);
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //Deselect all selected items
	      select.deselectAll();
	      
	   }
	}


