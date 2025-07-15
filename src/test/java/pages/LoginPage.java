package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email=By.name("email");
	By password=By.name("password");
	By submitBtn=By.xpath("//button[text()='Login']");
	
	public void enterEmail(String emailAddress)
	{
		driver.findElement(email).sendKeys(emailAddress);
	}
	
	public void enterPassword(String enterPass)
	{
		driver.findElement(password).sendKeys(enterPass);
	}
	public void clickLogin()
	{
		driver.findElement(submitBtn).click();
	}

}
