package BaseSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	public static WebDriver driver = null;
	public static Properties prop = null;
	
	// invoke browser
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");
		//initialize chrome driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		if(prop == null) 
		{
			prop = new Properties();
			
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Configuration\\config.properties");
				try {
					prop.load(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void Quit()
	{
		driver.quit();
	}
	
	public void OpenWebUrl(String Url)
	{
		driver.get(prop.getProperty(Url));
	}

}
