package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LoginPagePF;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {
	
	@Test
	public void  clickProductsTest()
	{
		
		LoginPagePF login=new LoginPagePF(driver);
		login.enterEmail("rishua1993@gmail.com");
		login.enterPassword("Bajajr@01");
		login.clickLogin();
	
		ProductsPage prod=new ProductsPage(driver);
		prod.clickProductLink();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleIs("Automation Exercise - All Products"));
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products", "Title not same");
		
		


		
	}

}
