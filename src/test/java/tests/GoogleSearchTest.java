package tests;

import org.testng.annotations.Test;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.GoogleHomePage;

@Epic("GoogleSearch Test")
@Feature("search the page")
public class GoogleSearchTest extends BaseTest {

	
	@Test(description = "Verify Google Search test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to Google Search and enter a value")
	public  void runTc() 
	{
		
        driver.get("https://www.google.com");
        GoogleHomePage googleHme=new GoogleHomePage(driver);
        googleHme.enterSearchBox("Selenium WebDriver");
        googleHme.submitSearch();
        System.out.println("Title: " + driver.getTitle());
        driver.quit();

	}

}
