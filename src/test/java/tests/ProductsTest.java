package tests;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.LoginPagePF;
import pages.ProductsPage;
import utils.ConfigReader;

@Epic("Add Product to cart and Checkout")
@Feature("Add Product to cart and Checkout")
public class ProductsTest extends BaseTest {
	
	
	@Test(description = "Navigate to url add product verify and checkout")
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to url add product verify and checkout")
	public void  clickProductsTest() throws InterruptedException
	{
		
		LoginPagePF login=new LoginPagePF(driver);
		Logger logger = Logger.getLogger(ProductsTest.class.getName());
		String email = ConfigReader.get("userEmail");
		String password = ConfigReader.get("userPassword");


		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLogin();
		String product="Stylish Dress";
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

		ProductsPage prod=new ProductsPage(driver);
		
		prod.clickProductLink();
		
		
		
		wait.until(ExpectedConditions.titleIs("Automation Exercise - All Products"));
		
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products", "Title not same");

		List<WebElement> lists=prod.allProds();
		
		for(WebElement e:lists)
		{

			if(e.getText().equals(product))
			{

				prod.addCart(product);
				logger.info(product + " is Added to cart");
		    	boolean isDisplayed=	prod.verificationMsg();
				Assert.assertTrue(isDisplayed);
			}
		}
		
		prod.clickOnViewCart();
		
		//Verify Cart 
		
		CartPage cart=new CartPage(driver);
		
		//cart.clickOncart();
		
		String theActualProd=cart.verifyCartProduct();
		Assert.assertEquals(theActualProd, product,"product In Cart not same");
		
		//Checkout
		CheckoutPage check=new CheckoutPage(driver);
		check.ClickCheckout();

		
	}

}
