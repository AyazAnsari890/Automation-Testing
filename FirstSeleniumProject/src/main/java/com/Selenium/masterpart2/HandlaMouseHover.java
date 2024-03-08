package com.Selenium.masterpart2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlaMouseHover {
	WebDriver driver = null;

	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}

	@Test
	public void HandleMouseHover() {
		driver.get("https://www.americangolf.co.uk/");
		WebElement clothLink = driver.findElement(By.xpath("//a[@class='a-level-1'][normalize-space()='Golf Shoes']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(clothLink).build().perform();
		
		//for the page to be displayed for sometime
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
