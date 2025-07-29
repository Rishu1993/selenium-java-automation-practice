package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By CheckOutLink=By.xpath("//a[text()='Proceed To Checkout']");
	
	@Step("click on proceed to checkout button")

	public void ClickCheckout()
	{
		driver.findElement(CheckOutLink).click();
	}
	
}
