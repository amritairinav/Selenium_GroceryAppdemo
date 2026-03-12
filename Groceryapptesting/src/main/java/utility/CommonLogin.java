package utility;

import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class CommonLogin {

    public void login(WebDriver driver, String username, String password) {

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterTheusername(username);
        loginpage.enterThepassword(password);
        loginpage.checkthCheckboxrememberme();
        loginpage.clickSignin();
    }
}