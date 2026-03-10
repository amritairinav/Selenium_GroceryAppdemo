package Utility;


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
    
    public void mouseHover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
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
     public void moveToelement(WebDriver driver,WebElement target) {
    	 Actions action = new Actions(driver);
    	 action.moveToElement(target);
    	 
     }

    public static void simpleAlertaccept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Dismiss Alert
    public static void confirmationAlertdismiss(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

       public static String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

       public static void enterTextpromptalert(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
    }




