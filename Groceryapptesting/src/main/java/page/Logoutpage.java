package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
	@FindBy(xpath="//img[@alt='User Image']/parent::a")
	WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	WebDriver driver;
	@FindBy(name="username")
	WebElement username;

	public Logoutpage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void admin() {
		admin.click();
	}

	public void logout() {
		logout.click();
	}
	public boolean isusernamedisplayed() {
        return username.isDisplayed();

}

}