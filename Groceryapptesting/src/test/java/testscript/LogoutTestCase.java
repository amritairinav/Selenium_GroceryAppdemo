package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import utility.ExcelUtility;

public class LogoutTestCase extends Base {

	public HomePage homepage;

	@Test(description = "Verify if user is able to log out", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)
	public void performLogout() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username).enterThepassword(password).checkthCheckboxrememberme();
		homepage = loginpage.clickSignin().admin().logOut();
		HomePage logout = new HomePage(driver);
		boolean field = logout.isUsernamedisplayed();
		Assert.assertTrue(field);

	}
}
