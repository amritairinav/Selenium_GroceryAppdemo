package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class LoginPage {
		
		@FindBy(name="username")WebElement username;
		@FindBy(name="password")WebElement password;
		@FindBy(xpath="//button[@type='submit']")WebElement submit;
		@FindBy(xpath="//label[@for='remember']")WebElement rememberme;
		@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
		@FindBy(css="button[data-dismiss='alert']") WebElement alert;
		
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void enterTheusername(String Username) {
			username.sendKeys(Username);
		}
		public void enterThepassword(String Password) {
		    password.sendKeys(Password);
		}
		public void checkthCheckboxrememberme() {
			rememberme.click();
		}
		public void clickSignin() {
			submit.click();
		}
		 public boolean isdashBoarddisplayed() {
		        return dashboard.isDisplayed();
			
	}
		 public boolean isalertdisplayed() {
		        return alert.isDisplayed();
	}
		 public String validationMessage() {
			 return username.getAttribute("ValidationMessage");
		 
		 }
	}
	