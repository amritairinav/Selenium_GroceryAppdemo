package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utility.Waitutility;



public class Base {
	public WebDriver driver;

	@BeforeMethod()

	public void browserInitialization() {
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waitutility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

		//@AfterMethod()
	public void browserQuit() {
		driver.quit();
	}

}
