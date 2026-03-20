package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.Waitutility;

public class ManageContactsPage {

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editbutton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@id='content' and @name='address']")
	WebElement address;
	@FindBy(xpath = "//textarea[@id='content' and @name='del_time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverylimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertmessage;

	WebDriver driver;
	Waitutility wait = new Waitutility();
	PageUtility page = new PageUtility();

	public ManageContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		public ManageContactsPage editButton() {
		editbutton.click();
		return this;
	}

	public ManageContactsPage updatePhone(String Phone) {
		phone.clear();
		phone.sendKeys(Phone);
		return this;

	}

	public ManageContactsPage updateEmail(String Email) {
		email.clear();
		email.sendKeys(Email);
		return this;

	}

	public ManageContactsPage updateAddress(String Address) {
		address.clear();
		address.sendKeys(Address);
		return this;

	}

	public ManageContactsPage deliveryTime(String Time) {
		deliverytime.clear();
		deliverytime.sendKeys(Time);
		return this;

	}

	public ManageContactsPage deliveryLimit(String Limit) {
		deliverylimit.clear();
		deliverylimit.sendKeys(Limit);
		return this;

	}

	public ManageContactsPage updatebutton() {
		page.movetoElement(driver, updatebutton);
		wait.waitForElementToBeClickable(driver, updatebutton);
		page.actionClick(driver, updatebutton);
		return this;
	}

	public boolean isalertDisplayed() {
		return alertmessage.isDisplayed();
	}

}