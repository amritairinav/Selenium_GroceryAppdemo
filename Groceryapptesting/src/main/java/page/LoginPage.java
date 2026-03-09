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
		
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void entertheusername(String Username1) {
			username.sendKeys(Username1);
		}
		public void enterthepassword(String password1) {
			password.sendKeys(password1);
		}
		
		public void checkthecheckboxrememberme() {
			rememberme.click();
		}
		public void clicksignin() {
			submit.click();
		}

}

	