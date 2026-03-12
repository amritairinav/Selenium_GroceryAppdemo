package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.AdminUserPage;
import utility.CommonLogin;
import utility.ExcelUtility;

public class AdminUserTestCase extends Base {
	@Test(description = "Verify if the user is able to add and save admin user details")
	public void addAdminuserInfo() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		CommonLogin login = new CommonLogin();
		login.login(driver, username, password);
		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.moreinfo();
		adminuser.newbutton();
		String username1 = ExcelUtility.getStringdata(1, 0, "AdminPage");
		String password1 = ExcelUtility.getStringdata(1, 1, "AdminPage");
		adminuser.enterUsername(username1);
		adminuser.enterPassword(password1);
		String dropdown = ExcelUtility.getStringdata(1, 2, "AdminPage");
		adminuser.dropdown(dropdown);
		adminuser.savebutton();
		boolean message = adminuser.isalertdisplayed();
		Assert.assertTrue(message);

	}
}
