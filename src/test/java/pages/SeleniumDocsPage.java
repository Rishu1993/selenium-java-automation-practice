package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumDocsPage {
	WebDriver driver;
	
	public SeleniumDocsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By documentation=By.xpath("//span[text()='Documentation']/parent::a");
	
	
	public void clickDocumentationLink()
	{
		driver.findElement(documentation).click();
	}

}
