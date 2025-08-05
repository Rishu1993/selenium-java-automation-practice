package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class PaymentPage {

	WebDriver driver;
	WebDriverWait wait;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "name_on_card")
	WebElement nameOnCard;

	@FindBy(xpath = "//button[text()='Pay and Confirm Order']")
	WebElement ConfirmOrder;

	@Step("enter name on card")
	public void enterNameOncard(String name) {
		nameOnCard.sendKeys(name);
	}

	@Step("click confirm order btn")
	public String clickConfirmOrder() {
		wait.until(ExpectedConditions.visibilityOf(ConfirmOrder));
		ConfirmOrder.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", ConfirmOrder);
		System.out.println(isValid);
		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", ConfirmOrder);
		return validationMsg;
	}

}
