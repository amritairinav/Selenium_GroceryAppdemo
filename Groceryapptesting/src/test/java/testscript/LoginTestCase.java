package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.LoginPage;
import utility.ExcelUtility;

public class LoginTestCase extends Base {

	@Test(priority = 1, description = "Verify login functionaility", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)

	public void login_validUsernameandcredentials() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username);
		loginpage.enterThepassword(password);
		loginpage.checkthCheckboxrememberme();
		loginpage.clickSignin();
		boolean page = loginpage.isdashBoarddisplayed();
		Assert.assertTrue(page);
	}

	@Test(priority = 2, description = "Verify login with valid username and invalid password", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)
	public void login_validusernameAndInvalidpassword() throws IOException {
		String username = ExcelUtility.getStringdata(2, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username);
		loginpage.enterThepassword(password);
		loginpage.checkthCheckboxrememberme();
		loginpage.clickSignin();
		boolean message = loginpage.isalertdisplayed();
		Assert.assertTrue(message, Constant.LOGIN_WITH_INCORRECTPASSWORD);
	}

	@Test(priority = 3, description = "Verify login with invalid username and valid password", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)

	public void login_invalidusernameAndValidpassword() throws IOException {
		String username = ExcelUtility.getStringdata(3, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username);
		loginpage.enterThepassword(password);
		loginpage.checkthCheckboxrememberme();
		loginpage.clickSignin();
		boolean message = loginpage.isalertdisplayed();
		Assert.assertTrue(message, Constant.LOGIN_WITH_INCORRECTPASSWORD);
	}

	@Test(priority = 4, description = "Verify login with invalid username and password", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)

	public void login_incorrectusernameAndpassword() throws IOException {
		String username = ExcelUtility.getStringdata(4, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username);
		loginpage.enterThepassword(password);
		loginpage.checkthCheckboxrememberme();
		loginpage.clickSignin();
		boolean message = loginpage.isalertdisplayed();
		Assert.assertTrue(message, Constant.LOGIN_WITH_INCORRECTPASSWORD);
	}

	@Test(priority = 5, description = "Verify login with empty username and password", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)
	public void login_emptyUsernameAndPassword() throws IOException {
		String username = ExcelUtility.getStringdata(5, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(5, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username);
		loginpage.enterThepassword(password);
		loginpage.checkthCheckboxrememberme();
		loginpage.clickSignin();
		Assert.assertEquals(Constant.LOGIN_EMPTY_FIELD_MESSAGE_ACTUAL, Constant.LOGIN_EMPTY_FIELD_MESSAGE_EXPECTED);
	}
}
