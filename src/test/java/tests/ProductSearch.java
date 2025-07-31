package tests;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPagePF;
import pages.ProductSearchPage;
import pages.ProductsPage;
import utils.ConfigReader;

@Test
public class ProductSearch extends BaseTest {
	
	public void  ProductSearchTest()
	{
	LoginPagePF login=new LoginPagePF(driver);
	Logger logger = Logger.getLogger(ProductSearch.class.getName());
	
	String email = ConfigReader.get("userEmail");
	String password = ConfigReader.get("userPassword");
		
	login.enterEmail(email);
	login.enterPassword(password);
	login.clickLogin();
	
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	ProductsPage prod=new ProductsPage(driver);
	prod.clickProductLink();
	
	ProductSearchPage prodSearch=new ProductSearchPage(driver);
	prodSearch.enterProd("Top");
	prodSearch.clickSearchBtn();
	
	List<WebElement> retrivedProds=prodSearch.listsOfProducts();
	
	for(WebElement prods:retrivedProds)
	{
		String actualProd=prods.getText().toLowerCase();
		logger.info("The Products received"+ actualProd);
	}

}}
