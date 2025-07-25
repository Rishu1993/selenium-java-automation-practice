package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.LoginPage;
import pages.LoginPagePF;
import pages.ProductsPage;

@Epic("Login")
@Feature("Login Feature")
public class LoginTest extends BaseTest {

	

	@Test(groups= {"smoke"},priority=1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to automationexercise and login")
	public void  LoginToSite()
	{
	    System.out.println("loginstarted");  // 👈 Debug print

	    LoginPage login=new LoginPage(driver);
		login.enterEmail("rishua1993@gmail.com");
		login.enterPassword("Bajajr@01");
		login.clickLogin();
	    System.out.println("Page Title: " + driver.getTitle());  // 👈 Debug print

		Assert.assertEquals(driver.getTitle(), "Automation Exercise","not same title");
		
	}
	
	@Test(groups= {"smoke"},priority=0)
	public void  LoginToSiteNegative()
	{
		
		LoginPage login=new LoginPage(driver);
		login.enterEmail("rishua1993@gmail.com");
		login.enterPassword("Bajajr@01@01");
		login.clickLogin();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise","not same title");

		
	}
}
