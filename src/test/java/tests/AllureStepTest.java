package tests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.testng.AllureTestNg;


public class AllureStepTest {

    @Test(description = "Basic test with Allure steps")
    @Description("Verifies that steps show in Allure")
    public void testStepsDemo() {
        openApplication();
        login("testuser");
        verifyDashboard();
    }

    @Step("Open the application")
    public void openApplication() {
        System.out.println("Application opened.");
    }

    @Step("Login with username: {0}")
    public void login(String username) {
        System.out.println("Logging in as: " + username);
    }

    @Step("Verify user is on dashboard")
    public void verifyDashboard() {
        System.out.println("Dashboard verified.");
    }
}
