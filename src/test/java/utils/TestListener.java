package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener {
	
	

	public void onTestFailure(ITestResult result) {
        // Ensure the test class is a child of BaseTest
        if (result.getInstance() instanceof BaseTest) {
            WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
            if (driver != null) {
                ScreenShot.takeScreenshot(driver); // Will be attached in Allure
            }
        }
    
	        
	        
}
	
	@Override
	public void onFinish(ITestContext context) {
	    int passed = context.getPassedTests().size();
	    int failed = context.getFailedTests().size();
	    int skipped = context.getSkippedTests().size();
	    int total = passed + failed + skipped;

	    long durationMillis = context.getEndDate().getTime() - context.getStartDate().getTime();
	    double durationSeconds = durationMillis / 1000.0;

	    System.out.println("\n================= TEST SUMMARY =================");
	    System.out.println("Total tests run: " + total);
	    System.out.println("Passed: " + passed);
	    System.out.println("Failed: " + failed);
	    System.out.println("Skipped: " + skipped);
	    System.out.printf("Execution time: %.2f seconds%n", durationSeconds);
	    System.out.println("=================================================\n");
	}

}