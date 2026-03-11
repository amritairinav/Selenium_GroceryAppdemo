package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException {
		// Take screenshot-interface
		//convert webdriver to screenshot mode-Typecasting
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);

		// Timestamp when multiple failures come and overlaps
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

		// Folder to save screenshots
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");

		// This creates folder if it does not exit
		if (!f1.exists()) {
			f1.mkdirs();
		}
		// Full destination path
		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedtestcase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);

		// Copy screenshot file
		FileHandler.copy(screenShot, finalDestination);

	}

}
