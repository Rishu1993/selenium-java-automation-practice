package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ProductsPage {
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	public By productsLink=By.xpath("//a[text()=' Products']");
	
	By listOfProds=By.xpath("//div[@class='productinfo text-center']//p");
	By verifcation=By.xpath("//p[text()='Your product has been added to cart.']");
	By viewCart=By.xpath("//u[text()='View Cart']/parent::a");
	
	public void clickProductLink()
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(productsLink));

		driver.findElement(productsLink).click();
	}

	public List<WebElement> allProds()
	{
		List<WebElement> listOfProd=driver.findElements(listOfProds);
		return listOfProd;
	}
	
	@Step("Add the product to cart")

	public void addCart(String productName)
	{
	     String dynamicXPath = "//p[text()='" + productName + "']/parent::div[@class='productinfo text-center']//a";

		driver.findElement(By.xpath(dynamicXPath)).click();
		
	}
	@Step("verify the message")

	public boolean verificationMsg()
	{
		boolean isDisplayed=driver.findElement(verifcation).isDisplayed();
		return isDisplayed;
		
	}
	
	@Step("Click on view cart after adding product to cart")

	public void clickOnViewCart()
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));

		driver.findElement(viewCart).click();
	}

}
