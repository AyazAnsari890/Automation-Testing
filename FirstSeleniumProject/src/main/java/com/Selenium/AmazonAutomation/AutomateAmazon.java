package com.Selenium.AmazonAutomation;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class AutomateAmazon {
	
	WebDriver driver = new ChromeDriver();
	

	
	
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='_18u87m _3WuvDp']")).sendKeys("8839463609");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@class='_1wGnMD rX1XT4 _2nD2xJ']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
	//	driver.quit();
		
	}
	
	public void SearchProduct()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
	driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("Phones",Keys.ENTER);
	}
	
	public void ExtractTextInSelenium()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		String headingText = driver.findElement(By.xpath("//a[@class='_1_3w1N']")).getText();
		System.out.println(headingText);
//		Assert.assertEquals(headingText,"Become a Seller");
	}
	@Test
	public void FindBrokenLink()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.edition.cnn.com/");
		List<WebElement> links = (List<WebElement>) driver.findElement(By.tagName("a"));
		System.out.println("no. of links are : " + links.size());
		
	}
	

}
