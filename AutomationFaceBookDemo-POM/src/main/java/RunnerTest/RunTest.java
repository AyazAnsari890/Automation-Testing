package RunnerTest;

import org.testng.annotations.Test;

import BaseSetup.Base;
import NewUserSignUp.SignUpPage;

public class RunTest extends Base
{
@Test
public void TestOne()
{
		SignUpPage b = new SignUpPage();
		invokeBrowser();
		OpenWebUrl("WebUrl");
		b.signUp();
		Quit();		
}
}
