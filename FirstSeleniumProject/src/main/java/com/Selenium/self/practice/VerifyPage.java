package com.Selenium.self.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyPage {

	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(enabled=false)
	public void verifyPageTitle() {
		driver.get("https://www.flipkart.com/");
		// Get the page title and do assertion
		String actualPageTitle = driver.getTitle();

		System.out.println("The title of the page is: " + actualPageTitle);
		Assert.assertEquals(actualPageTitle,
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		//Note: Get the page title by doing inspect go to the console and type docuemnt.title
	}
	
	@Test(enabled=false)
	public void presenceOfElement() {
		// Navigate to Google
		driver.get("https://www.google.com");

		// Find the search box and input text
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("katrina kaif");

		// Submit the search
		searchBox.submit();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// Verify if the search results contain the specified text
		
		 boolean textfound = driver.getPageSource().contains("katrina kaif");
		    if (textfound == true)
		    {
		     System.out.print("Element Found");
		    }
		    else
		    {
		     System.out.print("Not found");
		    }
		
		//Some other ways
		/* Way 2
		 driver.findElement(By.xpath("//*[contains(text(),'Java')]"));
		 Assert.assertTrue(true);
		 */
		
		
		/* Way 3
		 boolean isTextPresent = driver.findElement(By.tagName("body")).getText().contains("Java");

		// Print the result
		if (isTextPresent) {
			System.out.println("Text found in search results!");
		} else {
			System.out.println("Text not found in search results!");
		}
		 
		 */	
	}
	
	@Test
	public void pageSource()
	{
		driver.get("https://www.flipkart.com/");
		System.out.println("The url of this page is: " +driver.getCurrentUrl());
		System.out.println("The title of this page is: "+driver.getTitle());
		System.out.println("The id of this page is: "+driver.getWindowHandle());
		//System.out.println(driver.getPageSource());
	}
	
	

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
