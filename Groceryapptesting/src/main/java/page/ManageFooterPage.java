package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {

	@FindBy(xpath = "//p[text()='Manage Footer Text']/parent::div/parent::div/a")
	WebElement moreinfo;
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

	public void moreinfo() {
		moreinfo.click();
	}

    public void editButton() {
	editbutton.click();
}
    public void updateAddress(String Address) {
    	address.clear();
    	address.sendKeys(Address);
    	  	
    }
    public void updateEmail(String Email) {
    	email.clear();
    	email.sendKeys(Email);
    	  	
    }
    
    public void updatePhone(String Phone) {
    	phone.clear();
    	phone.sendKeys(Phone);
    	  	
    }
    public void updatebutton() {
    	updatebutton.click();
    	
    }

	public boolean isalertDisplayed() {
		return alertmessage.isDisplayed();
	}


    
}
    	
    	
    	
    	
    	
    	
    	