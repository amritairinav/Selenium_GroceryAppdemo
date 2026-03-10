package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.AdminUserPage;
import page.LoginPage;

public class LoginTestCase extends Base {

	@Test
	public void login() {

		String username1 = "admin";
		String password1 = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.entertheusername(username1);
		loginpage.enterthepassword(password1);
		loginpage.checkthecheckboxrememberme();
		loginpage.clicksignin();
		boolean page=loginpage.isdashBoarddisplayed();
		Assert.assertTrue(page);
	}
}
	
	
	