package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.FileUpload;
import Utility.Waitutility;

public class ManageCategoryPage {

	@FindBy(xpath = "//a[contains(@href,'list-category') and @class='small-box-footer']")
	WebElement moreinfo;
	@FindBy(css = "a[onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(css = "input#category")
	WebElement categories;
	@FindBy(xpath = "//li[contains(@class,'selectable')]")
	WebElement list;
	@FindBy(css = "input#main_img")
	WebElement uploadimage;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertmessage;

	WebDriver driver;
	Waitutility waitUtil;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtil = new Waitutility();
		PageFactory.initElements(driver, this);
	}

	public void moreinfo() {
		moreinfo.click();
	}

	public void newbutton() {
		newbutton.click();
	}

	public void enterCategory(String category) {

		categories.sendKeys(category);
	}

	public void clickList() {

		list.click();
	}

	public void uploadAdminImage() {

		FileUpload upload = new FileUpload();
		String filepath = "C:\\Users\\Anvith\\Desktop\\JavaExcel\\image1.JPG";
		upload.uploadFile(uploadimage, filepath);
	}
	
	 public void savebutton() {
		 waitUtil.waitForElementTobeVisible(driver,savebutton);
	     waitUtil.waitForElementToBeClickable(driver,savebutton);
		 Actions action = new Actions(driver);
		 action.moveToElement(savebutton).perform();
         savebutton.click();
	       	    }

	 public boolean isalertdisplayed() {
		 return alertmessage.isDisplayed();
	 }
	
}
