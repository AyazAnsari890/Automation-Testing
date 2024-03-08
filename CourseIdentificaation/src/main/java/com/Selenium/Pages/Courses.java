package com.Selenium.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium.Base.Base;

public class Courses extends Base
{
	By search = By.xpath("//input[@placeholder='What do you want to learn?']");
	By button = By.xpath("//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']");
	//By level = By.xpath("//span[@id='cds-react-aria-77-label-text']"); //"//div[text()='Level']"
	By Beginner = By.xpath("//*[@id='cds-react-aria-809']");
	
	public void findCourses()
	{
		driver.findElement(search).sendKeys("Web Development courses",Keys.ENTER);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		// Wait for the search results page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cds-9 css-0 cds-11 cds-grid-item cds-56 cds-81']")));
        
        // Filter by English language
        WebElement languageFilter = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(1) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1)"));
        languageFilter.click();
        
        // Filter by beginner level
        WebElement beginnerLevelFilter = driver.findElement(By.xpath("//span[contains(text(),'Beginner')]"));
        beginnerLevelFilter.click();
        
        // Wait for the search results page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cds-9 css-0 cds-11 cds-grid-item cds-56 cds-81']")));
	}
	
	public void displayCourses()
	{
        // Find all course elements
        List<WebElement> courseElements = driver.findElements(By.xpath("//div[@class='cds-9 css-0 cds-11 cds-grid-item cds-56 cds-81']"));

        // Iterate through each course element and extract information
        for (WebElement courseElement : courseElements) {
            // Extract course name
            String courseName = courseElement.findElement(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']")).getText();

            // Extract duration
            String duration = courseElement.findElement(By.xpath("//div[@class='cds-CommonCard-metadata']/child::p[@class=' css-10r3ar9']")).getText();

            // Extract rating
            String rating = courseElement.findElement(By.xpath("//div[@class='cds-CommonCard-ratings']")).getText();

            // Print course information
            System.out.println("Course Name: " + courseName);
            System.out.println("Duration: " + duration);
            System.out.println("Rating: " + rating);
            System.out.println("-------------------------------------------");
        }
	}
        
        public void displayTwoCourses()
        {
        	By course_names = By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']");
        	By course_durations = By.xpath("//div[@class='cds-CommonCard-metadata']/child::p[@class=' css-10r3ar9']");
        	By course_ratings = By.xpath("//div[@class='cds-CommonCard-ratings']");
        	
        	
        	List<WebElement> course_name  = driver.findElements(course_names);
        	List<WebElement> course_duration  = driver.findElements(course_durations);
        	List<WebElement> course_rating  = driver.findElements(course_ratings);
        	for(int i=0;i<2;i++)
        		System.out.println(course_name.get(i).getText() + " " + course_duration.get(i).getText() + " " + course_rating.get(i).getText());
        		//System.out.println(course_duration.get(i).getText());
        		//System.out.println(course_rating.get(i).getText());
        	
        }
        
      
        
        
      
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		//driver.findElement(button);
		//driver.findElement(level).click();
		//driver.findElement(Beginner).click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
}
