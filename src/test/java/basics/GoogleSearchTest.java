package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("q")).submit();

        System.out.println("Title: " + driver.getTitle());
        driver.quit();

	}

}
