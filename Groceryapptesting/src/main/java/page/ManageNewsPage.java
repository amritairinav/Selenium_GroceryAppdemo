package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	@FindBy(xpath = "//p[text()='Manage News']/parent::div/parent::div//a")
	WebElement moreinfo;
	@FindBy(css = "a[onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newstextarea;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertmessage;

	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void moreinfo() {
		moreinfo.click();
	}

	public void newbutton() {
		newbutton.click();
	}

	public void newstextarea(String newstextarea1) {
		newstextarea.sendKeys(newstextarea1);

	}

	public void savebutton() {
		savebutton.click();
	}

	public boolean isalertdisplayed() {
		return alertmessage.isDisplayed();
	}
}
