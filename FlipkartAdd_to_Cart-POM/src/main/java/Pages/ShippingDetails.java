package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import BasicSetup.Base;

public class ShippingDetails extends Base 
{
	public void delieveryDetails() 
	{
		// Add the address
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7250621471", Keys.ENTER);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Enter OTP Manualy
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click on Login Button
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
