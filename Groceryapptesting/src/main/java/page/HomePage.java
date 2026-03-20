package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Waitutility;

public class HomePage {

	@FindBy(xpath = "//img[@alt='User Image']/parent::a")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(name = "username")
	WebElement username;
	@FindBy(xpath = "//p[text()='Manage News']/parent::div/parent::div//a")
	WebElement ManageNewsmoreinfo;
	@FindBy(xpath = "//p[text()='Manage Footer Text']/parent::div/parent::div/a")
	WebElement ManageFooterinfo;
	@FindBy(xpath = "//a[contains(@href,'list-contact') and @class='small-box-footer']")
	WebElement ManageContactmoreinfo;
	@FindBy(xpath = "//a[contains(@href,'list-category') and @class='small-box-footer']")
	WebElement ManageCategorymoreinfo;
	@FindBy(xpath = "(//a[contains(@class,'small-box-footer')])[1]")
	WebElement AdminUserPagemoreinfo;

	WebDriver driver;
	Waitutility wait = new Waitutility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage admin() {
		admin.click();
		return this;
	}

	public HomePage logOut() {
		logout.click();
		return this;
	}

	public ManageNewsPage manageNewsmoreinfo() {
		ManageNewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public ManageFooterPage manageFootermoreinfo() {
		ManageFooterinfo.click();
		return new ManageFooterPage(driver);
	}

	public ManageContactsPage manageContactmoreinfo() {
		ManageContactmoreinfo.click();
		return new ManageContactsPage(driver);
	}

	public ManageCategoryPage manageCategorymoreinfo() {
		ManageCategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}

	public AdminUserPage adminUserPagemoreinfo() {
		wait.waitForElementToBeClickable(driver, AdminUserPagemoreinfo);
		AdminUserPagemoreinfo.click();
		return new AdminUserPage(driver);
	}

	public boolean isUsernamedisplayed() {
		return username.isDisplayed();

	}

}