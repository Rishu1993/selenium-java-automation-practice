package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;


public class BaseTest {
	protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	System.out.println("🔧 BeforeMethod running...");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ConfigReader.loadProperties();

		driver.get("https://automationexercise.com/login");
	    System.out.println("Driver Initialized: " + driver); // 👈 Add this line


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
