package NewUserSignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseSetup.Base;

public class SignUpPage extends Base
{
	
	By firstname = By.name("firstname");
	By lastname = By.name("lastname");
	By mobNo = By.name("reg_email__");
	By password = By.name("reg_passwd__");
	By submit = By.xpath("//button[@name=\"websubmit\"]");
	
	public void signUp() 
	{
		
		driver.findElement(firstname).sendKeys("John");
		driver.findElement(lastname).sendKeys("Snow");
		driver.findElement(mobNo).sendKeys("7868594836");
		driver.findElement(password).sendKeys("RuthlessAegon@123");		
		
		//Locator for DOB
		WebElement birthdate = driver.findElement(By.name("birthday_day"));
		WebElement birthmonth = driver.findElement(By.name("birthday_month"));
		WebElement birthyear = driver.findElement(By.name("birthday_year"));
		
		//Select Birth date
		Select select = new Select(birthdate);
    	select.selectByIndex(5);
    	
    	//Select Birth month
    	Select select2 = new Select(birthmonth);
    	select2.selectByVisibleText("Dec");
    	
    	//Select Birth year
    	Select select3 = new Select(birthyear);
    	select3.selectByVisibleText("1920");
    	
    	//Select Gender
    	 WebElement gender_female = driver.findElement(By.xpath("//input[@value=1]"));
    	 WebElement gender_male = driver.findElement(By.xpath("//input[@value=2]"));
    	 gender_male.click();
    	 
    	 //driver.findElement(submit).click(); 	
    	
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}
	
	
}
