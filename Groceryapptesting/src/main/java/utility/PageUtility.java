package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void dropdownVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void dropdownValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void dropdownIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void dropdownAlloptions(WebElement element) {
		Select select = new Select(element);
		select.getOptions();

	}

	public void actionClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void movetoElement(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target);
	}

	public void simpleAlertaccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void confirmationAlertdismiss(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void enterTextpromptalert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void selectCheckbox(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unselectCheckbox(WebElement element) {
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isCheckboxSelected(WebElement element) {
		return element.isSelected();
	}

	public void selectRadiobutton(WebElement element) {
		if (!element.isSelected()) {
			element.click();
		}
	}

	public boolean isRadiobuttonSelected(WebElement element) {
		return element.isSelected();
	}
}
