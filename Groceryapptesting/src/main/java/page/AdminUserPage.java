package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.Waitutility;

public class AdminUserPage {

	@FindBy(css = "a[onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement dropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertmessage;

	WebDriver driver;
	Waitutility wait = new Waitutility();
	PageUtility page = new PageUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUserPage newbutton() {
		wait.waitForElementToBeClickable(driver, newbutton);
		newbutton.click();
		return this;
	}

	public AdminUserPage enterUsername(String Username) {
		wait.waitForElementToBeClickable(driver, username);
		username.sendKeys(Username);
		return this;
	}

	public AdminUserPage enterPassword(String Password) {
		wait.waitForElementToBeClickable(driver, password);
		password.sendKeys(Password);
		return this;
	}

	public AdminUserPage dropdown(String Dropdown) {
		page.dropdownVisibleText(dropdown, Dropdown);
		return this;
	}

	public AdminUserPage savebutton() {
		savebutton.click();
		return this;
	}

	public boolean isalertdisplayed() {
		return alertmessage.isDisplayed();
	}

}
