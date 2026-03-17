package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.Logoutpage;
import utility.CommonLogin;
import utility.ExcelUtility;

public class LogoutTestCase extends Base {

	@Test(description = "Verify if user is able to log out",groups = {
	"Regression" }, retryAnalyzer = retry.Retry.class)
	public void performLogout() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		CommonLogin login = new CommonLogin();
		login.login(driver, username, password);
		Logoutpage logout = new Logoutpage(driver);
		logout.admin();
		logout.logOut();
		boolean field = logout.isUsernamedisplayed();
		Assert.assertTrue(field);

	}
}
