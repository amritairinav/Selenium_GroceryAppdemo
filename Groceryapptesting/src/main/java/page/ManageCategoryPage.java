package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utility.FileUpload;
import utility.PageUtility;
import utility.Waitutility;

public class ManageCategoryPage {

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
	Waitutility wait = new Waitutility();
	PageUtility page = new PageUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public ManageCategoryPage newButton() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage enterCategory(String category) {

		categories.sendKeys(category);
		return this;
	}

	public ManageCategoryPage clickList() {

		list.click();
		return this;
	}

	public ManageCategoryPage uploadAdminImage() {

		FileUpload upload = new FileUpload();
		upload.uploadFile(uploadimage, Constant.IMAGEFILE);
		return this;
	}

	public ManageCategoryPage saveButton() {
		page.movetoElement(driver, savebutton);
		wait.waitForElementToBeClickable(driver, savebutton);
		page.actionClick(driver, savebutton);
		return this;

	}

	public boolean isalertDisplayed() {
		return alertmessage.isDisplayed();
	}

}
