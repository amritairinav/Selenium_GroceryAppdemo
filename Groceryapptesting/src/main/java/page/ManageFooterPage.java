package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {

	@FindBy(xpath = "(//i[contains(@class,'fa-edit')])[1]")
	WebElement editbutton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement address;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertmessage;

	WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageFooterPage editButton() {
		editbutton.click();
		return this;
	}

	public ManageFooterPage updateAddress(String Address) {
		address.clear();
		address.sendKeys(Address);
		return this;

	}

	public ManageFooterPage updateEmail(String Email) {
		email.clear();
		email.sendKeys(Email);
		return this;

	}

	public ManageFooterPage updatePhone(String Phone) {
		phone.clear();
		phone.sendKeys(Phone);
		return this;

	}

	public ManageFooterPage updatebutton() {
		updatebutton.click();
		return this;

	}

	public boolean isalertDisplayed() {
		return alertmessage.isDisplayed();
	}

}
