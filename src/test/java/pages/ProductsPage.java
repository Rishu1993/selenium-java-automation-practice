package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By productsLink=By.xpath("//a[text()=' Products']");
	
	public void clickProductLink()
	{
		driver.findElement(productsLink).click();
	}

	

}
