package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import BasicSetup.Base;

public class SearchForProduct extends Base
{
	
	public void searchProduct()
	{
		//Search for the product in searchbox
		driver.findElement(By.name("q")).sendKeys("iphones", Keys.ENTER);
		
		//Select the product
		driver.findElement(By.xpath("//div[normalize-space()='APPLE iPhone 14 (Midnight, 128 GB)']")).click();
		
		//After selecting the product next page is opened
		//Switch to next window
		Set<String> s = driver.getWindowHandles();
		ArrayList arr = new ArrayList(s);
		driver.switchTo().window((String)arr.get(1));
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		
		driver.switchTo().window((String)arr.get(1));
		
		//Add to Cart
		driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Place the Order
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
}
