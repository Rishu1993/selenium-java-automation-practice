package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By CartLink=By.xpath("//a[text()=' Cart']");
	By prodinPage=By.xpath("//tbody//tr//td[@class='cart_description']//a");
	
	@Step("Click on Cart link")
	public void clickOncart()
	{
		driver.findElement(CartLink).click();
	}
	
	@Step("Get product name from cart for verification")
	public String verifyCartProduct()
	{
	String prodInCart=	driver.findElement(prodinPage).getText();
	return prodInCart;
		
	}

}
