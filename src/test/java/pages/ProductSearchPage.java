package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ProductSearchPage {
	
	
WebDriver driver;
WebDriverWait wait;
	
	public ProductSearchPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	By producSearch=By.xpath("//input[@placeholder='Search Product']");
	By clickSearchBtn=By.id("submit_search");
	By productList=By.xpath("//div[@class='productinfo text-center']//p");
	
	@Step("enterProd")
	public void enterProd(String prod)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(producSearch));
		driver.findElement(producSearch).sendKeys(prod);
	}
	
	@Step("clickSearchBtn")
	public void clickSearchBtn()
	{
	
		driver.findElement(clickSearchBtn).click();
	}
	
	@Step("listsOfProducts")
	public List<WebElement> listsOfProducts()
	{
	
		List<WebElement> lists=driver.findElements(productList);
		return lists;
		
	}
	

}
