package TestRunner;

import org.testng.annotations.Test;

import BasicSetup.Base;
import Pages.SearchForProduct;
import Pages.ShippingDetails;
import Pages.SignIn;

public class RunTest extends Base
{
	
	@Test
	public void testOne()
	{
		SignIn s = new SignIn();
		SearchForProduct sp = new SearchForProduct();
		ShippingDetails sd = new ShippingDetails();
		
		//Callling the methods
		invokeBrowser();
		openUrl("WebSite");
		//s.Login();
		sp.searchProduct();
		sd.delieveryDetails();
		
		closeBrowser();
		
	}

}
