package Pages;

import java.time.Duration;

import org.openqa.selenium.By;


import BasicSetup.Base;

public class SignIn extends Base {
	
	By mobNo = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	By Otp = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	By Verify = By.xpath("//button[@class='_2KpZ6l _14EHzR _3dESVI']");
	
	public void Login()
	{
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(mobNo).sendKeys("7250621471");
		driver.findElement(Otp).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(Verify).click();
		
	}

}
