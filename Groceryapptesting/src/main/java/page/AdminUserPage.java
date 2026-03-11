package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import Utility.PageUtility;
import Utility.Waitutility;

public class AdminUserPage {

	@FindBy(xpath = "(//a[contains(@class,'small-box-footer')])[1]")
	WebElement moreinfo;
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
	Waitutility waitUtil;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtil = new Waitutility();
		PageFactory.initElements(driver, this);
	}

	public void moreinfo() {
		waitUtil.waitForElementToBeClickable(driver, moreinfo);
		moreinfo.click();
	}
	public void newbutton() {
		waitUtil.waitForElementToBeClickable(driver, newbutton);
		newbutton.click();
	}

	public void enterusername(String Username) {
		waitUtil.waitForElementToBeClickable(driver, username);
		username.sendKeys(Username);
	}

	public void enterpassword(String Password) {
		waitUtil.waitForElementToBeClickable(driver, password);
		password.sendKeys(Password);
	}

	public void dropdown(String Dropdown) {
		PageUtility pu = new PageUtility();
		pu.dropdownVisibleText(dropdown, Dropdown);
	}

	public void savebutton() {
		savebutton.click();
	}
	 public boolean isalertdisplayed() {
		 return alertmessage.isDisplayed();
	 }
	
}
