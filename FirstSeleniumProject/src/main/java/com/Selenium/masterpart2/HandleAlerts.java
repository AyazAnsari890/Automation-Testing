package com.Selenium.masterpart2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAlerts 
{
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
    public void HandleAlert()
    {
    	driver.get("https://www.rediff.com");
    	//click in Sign button
    	driver.findElement(By.linkText("Sign in")).click();
    	
    	WebElement username = driver.findElement(By.id("login1"));
    	username.sendKeys("anshulc55@rediff.com");
    	
    	// click on sign in button
    	driver.findElement(By.name("proceed")).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.alertIsPresent());
    	
    	Alert alt = driver.switchTo().alert();
    	System.out.println(alt.getText());
    	
    	alt.accept();
    	
    	driver.findElement(By.id("password")).sendKeys("Test@123");
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

}
