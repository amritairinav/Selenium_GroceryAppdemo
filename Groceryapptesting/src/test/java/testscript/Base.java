package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utility.ScreenshotUtility;
import utility.Waitutility;

public class Base {
	public WebDriver driver;

	@BeforeMethod()

	public void browserInitialization() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waitutility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
		// Take screenshot on failure
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, iTestResult.getName());

		}
		driver.quit();
	}
}
