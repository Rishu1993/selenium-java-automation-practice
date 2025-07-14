package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
	
	WebDriver driver;
	
	public GoogleHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchBox=By.name("q");
	
	public void enterSearchBox(String text)
	{
		driver.findElement(searchBox).sendKeys(text);
	}
	
	
	public void submitSearch() {
        driver.findElement(searchBox).submit();
    }
	
	

}
