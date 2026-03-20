package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageCategoryPage;
import utility.ExcelUtility;

public class ManageCategoryTestcase extends Base {
	public HomePage homepage;
	public ManageCategoryPage managecategorypage;

	@Test(description = "Verify if the user is able to add and save new categories", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)
	public void addCategory() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username).enterThepassword(password).checkthCheckboxrememberme();
		homepage = loginpage.clickSignin();
		managecategorypage = homepage.manageCategorymoreinfo();
		String Category = ExcelUtility.getStringdata(1, 0, "CategoryPage");
		managecategorypage.newButton().enterCategory(Category).clickList().uploadAdminImage().saveButton();
		boolean message = managecategorypage.isalertDisplayed();
		Assert.assertTrue(message, Constant.Category_Created_Successfully);
	}

}
