 package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.SeleniumDocsPage;


@Epic("Selenium Site Tests")
@Feature("Documentation Page")
public class SeleniumDocsTest extends BaseTest {
	
	@Test(description = "Verify title of Selenium documentation page",groups = {"Smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Navigate to Selenium.dev and verify the documentation page title")
	public void runSeleniumDocsTest()
	{
		
		driver.get("https://www.selenium.dev/");
		SeleniumDocsPage selc=new SeleniumDocsPage(driver);
		selc.clickDocumentationLink();
		String getTitle=driver.getTitle();
		
		if(getTitle.contains("The Selenium Browser Automation Project"))
		{
			System.out.print("The Title is verified");
		}
		else
			
		{
			System.out.print("The Title is not verified");
		}
		
	}

}
