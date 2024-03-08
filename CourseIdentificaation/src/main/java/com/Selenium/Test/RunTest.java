package com.Selenium.Test;

import org.testng.annotations.Test;

import com.Selenium.Base.Base;
import com.Selenium.Pages.Courses;

public class RunTest extends Base
{

	@Test
	public void testOne()
	{
		Courses c = new Courses();
		invokeBrowser();
		openURL("websiteURL");
		c.findCourses();
		//c.displayCourses();
		c.displayTwoCourses();
		quitBrowser();
	}
}
