package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.ManageCategoryPage;
import utility.CommonLogin;
import utility.ExcelUtility;

public class ManageCategoryTestcase extends Base {
	@Test(description = "Verify if the user is able to add and save new categories",groups = {
	"Regression" }, retryAnalyzer = retry.Retry.class)
	public void addCategory() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		CommonLogin login = new CommonLogin();
		login.login(driver, username, password);
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.moreinfo();
		managecategorypage.newButton();
		String Category = ExcelUtility.getStringdata(1, 0, "CategoryPage");
		managecategorypage.enterCategory(Category);
		managecategorypage.clickList();
		managecategorypage.uploadAdminImage();
		managecategorypage.saveButton();
		boolean message = managecategorypage.isalertDisplayed();
		Assert.assertTrue(message, Constant.Category_Created_Successfully);
	}

}
