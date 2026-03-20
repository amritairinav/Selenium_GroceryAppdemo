package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.AdminUserPage;
import page.HomePage;
import page.LoginPage;
import utility.ExcelUtility;

public class AdminUserTestCase extends Base {
	public HomePage homepage;
	public AdminUserPage adminuserpage;

	@Test(description = "Verify if the user is able to add and save admin user details", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)
	public void addAdminuserInfo() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username).enterThepassword(password).checkthCheckboxrememberme();
		homepage = loginpage.clickSignin();
		adminuserpage = homepage.adminUserPagemoreinfo();
		String username1 = ExcelUtility.getStringdata(1, 0, "AdminPage");
		String password1 = ExcelUtility.getStringdata(1, 1, "AdminPage");
		String dropdown = ExcelUtility.getStringdata(1, 2, "AdminPage");
		adminuserpage.newbutton().enterUsername(username1).enterPassword(password1).dropdown(dropdown).savebutton();
		boolean message = adminuserpage.isalertdisplayed();
		Assert.assertTrue(message, Constant.Admin_User_Created_Successfully);

	}
}
