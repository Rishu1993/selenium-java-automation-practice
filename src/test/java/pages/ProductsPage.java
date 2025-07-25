package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public By productsLink=By.xpath("//a[text()=' Products']");
	
	By listOfProds=By.xpath("//div[@class='productinfo text-center']//p");
	By verifcation=By.xpath("//p[text()='Your product has been added to cart.']");
	
	public void clickProductLink()
	{
		driver.findElement(productsLink).click();
	}

	public List<WebElement> allProds()
	{
		List<WebElement> listOfProd=driver.findElements(listOfProds);
		return listOfProd;
	}
	
	public void addCart(String productName)
	{
	     String dynamicXPath = "//p[text()='" + productName + "']/parent::div[@class='productinfo text-center']//a";

		driver.findElement(By.xpath(dynamicXPath)).click();
		
	}
	public boolean verificationMsg()
	{
		boolean isDisplayed=driver.findElement(verifcation).isDisplayed();
		return isDisplayed;
		
	}

}
