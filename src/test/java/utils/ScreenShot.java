package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	
	public String takeScreenshot(WebDriver driver,String testName) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    String dest = "./screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
	    try {
	        FileUtils.copyFile(src, new File(dest));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return dest;
	}
}
