package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
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

		public ManageNewsPage newbutton() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage newsTextarea(String newstextarea1) {
		newstextarea.sendKeys(newstextarea1);
		return this;

	}

	public ManageNewsPage savebutton() {
		savebutton.click();
		return this;
	}

	public boolean isalertdisplayed() {
		return alertmessage.isDisplayed();
	}
}
