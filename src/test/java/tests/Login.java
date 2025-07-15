package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.LoginPage;
import pages.ProductsPage;

@Epic("Login")
@Feature("Login Feature")
public class Login extends BaseTest {

	

	@Test(description = "Verify login Functality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to automationexercise and login")
	public void  LoginToSite()
	{
		
		LoginPage login=new LoginPage(driver);
		login.enterEmail("rishua1993@gmail.com");
		login.enterPassword("Bajajr@01");
		login.clickLogin();
		
		


		
	}
}
