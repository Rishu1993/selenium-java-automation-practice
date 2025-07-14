package tests;

import org.testng.annotations.Test;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {

	@Test
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
