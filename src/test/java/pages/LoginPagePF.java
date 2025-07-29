package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.qameta.allure.Step;

public class LoginPagePF {
	
	
	WebDriver driver;
	
	public LoginPagePF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="email")
	WebElement email;
	
	@FindBy (name="password")
	WebElement passwords;
	
	@FindBy (xpath="//button[text()='Login']")
	WebElement submitBtn;
	
	@Step("enterEmail")

	public void enterEmail(String emailAddress)
	{
		email.sendKeys(emailAddress);
	}
	
	@Step("enterPassword")

	public void enterPassword(String enterPass)
	{
		passwords.sendKeys(enterPass);
	}
	
	@Step("clickLogin")
	public void clickLogin()
	{
		submitBtn.click();
	}

}
