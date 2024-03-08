package com.Selenium.self.practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
	


	@Test
	    public  void reportGeneration() {
	        // Set the path to ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64n22\\chromedriver-win64\\chromedriver.exe");

	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Open Flipkart
	        driver.get("https://www.flipkart.com/");

	        // Get the page title
	        String actualTitle = driver.getTitle();

	        // Verify the page title
	        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	        boolean isTitleMatch = actualTitle.equals(expectedTitle);

	        // Generate HTML report
	        generateHTMLReport(actualTitle, expectedTitle, isTitleMatch);

	        // Close the browser
	        driver.quit();
	    }

	    private static void generateHTMLReport(String actualTitle, String expectedTitle, boolean isTitleMatch) {
	        try {
	            File file = new File("flipkart-title-verification-report.html");
	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            writer.write("<html><body>");
	            writer.write("<h2>Flipkart Page Title Verification Report</h2>");
	            writer.write("<p>Actual Title: " + actualTitle + "</p>");
	            writer.write("<p>Expected Title: " + expectedTitle + "</p>");
	            writer.write("<p>Verification Result: " + (isTitleMatch ? "Pass" : "Fail") + "</p>");
	            writer.write("</body></html>");
	            writer.close();
	            System.out.println("Report generated successfully: " + file.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



