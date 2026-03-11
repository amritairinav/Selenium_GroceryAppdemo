package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.AdminUserPage;
import page.LoginPage;
import Utility.ExcelUtility;

public class LoginTestCase extends Base {

	@Test
	public void login() throws IOException {
		String username1 = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.entertheusername(username1);
		loginpage.enterthepassword(password1);
		loginpage.checkthecheckboxrememberme();
		loginpage.clicksignin();
		boolean page = loginpage.isdashBoarddisplayed();
		Assert.assertTrue(page);
	}
}
