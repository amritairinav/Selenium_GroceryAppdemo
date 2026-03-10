package Utility;

import org.openqa.selenium.WebDriver;

import page.LoginPage;

public class CommonLogin {

    public CommonLogin(WebDriver driver, String username, String password) {

        LoginPage loginpage = new LoginPage(driver);
        loginpage.entertheusername(username);
        loginpage.enterthepassword(password);
        loginpage.checkthecheckboxrememberme();
        loginpage.clicksignin();
    }

}