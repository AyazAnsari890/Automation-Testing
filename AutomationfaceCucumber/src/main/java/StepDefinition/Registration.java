package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Registration
{
	WebDriver driver;
	
	@Given("Facebook webPage is Opened")
	public void facebook_webPage_is_opened()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Then("Enter User Details")
	public void enter_user_details()
	{
		//Enter firstnaeme
		driver.findElement(By.name("firstname")).sendKeys("John");
		driver.findElement(By.name("lastname")).sendKeys("Snow");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Qwerty@123");
		driver.findElement(By.name("reg_email__")).sendKeys("Know_nothing@gmail.com");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		Select select1 = new Select(day);
		Select select2 = new Select(month);
		Select select3 = new Select(year);
		
		select1.selectByValue("29");
		select2.selectByVisibleText("Feb");
		select3.selectByVisibleText("2000");
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("click on Submit button")
	public void click_on_submit_button()
	{
		
		driver.findElement(By.name("websubmit")).click();
		driver.quit();
		
	}
}
