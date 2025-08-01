package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;

	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	}

	By CheckOutLink=By.xpath("//a[text()='Proceed To Checkout']");
	
	@Step("click on proceed to checkout button")

	public void ClickCheckout()
	{
	    wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutLink));

		driver.findElement(CheckOutLink).click();
	}
	
}
