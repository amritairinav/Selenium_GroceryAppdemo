package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.Waitutility;

public class ManageContactsPage {
	@FindBy(xpath = "//a[contains(@href,'list-contact') and @class='small-box-footer']")
	WebElement moreinfo;
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

	public void moreinfo() {
		moreinfo.click();
	}

	public void editButton() {
		editbutton.click();
	}

	public void updatePhone(String Phone) {
		phone.clear();
		phone.sendKeys(Phone);

	}

	public void updateEmail(String Email) {
		email.clear();
		email.sendKeys(Email);

	}

	public void updateAddress(String Address) {
		address.clear();
		address.sendKeys(Address);

	}

	public void deliveryTime(String Time) {
		deliverytime.clear();
		deliverytime.sendKeys(Time);

	}

	public void deliveryLimit(String Limit) {
		deliverylimit.clear();
		deliverylimit.sendKeys(Limit);

	}

	public void updatebutton() {
		page.movetoElement(driver, updatebutton);
		wait.waitForElementToBeClickable(driver, updatebutton);
	    page.actionClick(driver, updatebutton);
	}

	public boolean isalertDisplayed() {
		return alertmessage.isDisplayed();
	}

}