package tests;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.LoginPagePF;
import pages.ProductSearchPage;
import pages.ProductsPage;
import utils.ConfigReader;

@Epic("Search Functionality")
@Feature("Search & Filter")
public class ProductSearch extends BaseTest {
	
    @Test(description = "Verify product search returns expected results")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test valid product search and validate each result")
	public void  ProductSearchTest()
	{
	LoginPagePF login=new LoginPagePF(driver);
	Logger logger = Logger.getLogger(ProductSearch.class.getName());
    String searchTerm = "Top";

	
	String email = ConfigReader.get("userEmail");
	String password = ConfigReader.get("userPassword");
	String url=ConfigReader.get("url");
	driver.get(url);
	login.enterEmail(email);
	login.enterPassword(password);
	login.clickLogin();
	
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	ProductsPage prod=new ProductsPage(driver);
	prod.clickProductLink();
	
	ProductSearchPage prodSearch=new ProductSearchPage(driver);
	prodSearch.enterProd(searchTerm);
	prodSearch.clickSearchBtn();
	
	List<WebElement> retrivedProds=prodSearch.listsOfProducts();
    Assert.assertTrue(retrivedProds.size() > 0, "No products were found for the search term: " + searchTerm);

	for(WebElement prods:retrivedProds)
	{
		String actualProd=prods.getText().toLowerCase();
		logger.info("The Products received"+ actualProd);
	}

}}
