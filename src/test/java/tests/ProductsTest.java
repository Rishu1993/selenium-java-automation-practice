package tests;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebElement;
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
	public void  clickProductsTest() throws InterruptedException
	{
		
		LoginPagePF login=new LoginPagePF(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		login.enterEmail("rishua1993@gmail.com");
		login.enterPassword("Bajajr@01");
		login.clickLogin();
		String product="Stylish Dress";
	
		ProductsPage prod=new ProductsPage(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(prod.productsLink));

		prod.clickProductLink();
		
		
		
		wait.until(ExpectedConditions.titleIs("Automation Exercise - All Products"));
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products", "Title not same");
		Thread.sleep(10000);

		List<WebElement> lists=prod.allProds();
		
		for(WebElement e:lists)
		{

			if(e.getText().equals(product))
			{
Thread.sleep(3000);
				prod.addCart(product);
				System.out.println("Added to cart");
				Thread.sleep(3000);
			boolean isDisplayed=	prod.verificationMsg();
				Assert.assertTrue(isDisplayed);
			}
		}
		


		
	}

}
