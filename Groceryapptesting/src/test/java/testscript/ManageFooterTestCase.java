package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.ManageFooterPage;
import utility.CommonLogin;
import utility.ExcelUtility;

public class ManageFooterTestCase extends Base {

	@Test(description = "Verify if user is able to update footer informations",groups = {
	"Regression" }, retryAnalyzer = retry.Retry.class)

	public void updateFooterinformations() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		CommonLogin login = new CommonLogin();
		login.login(driver, username, password);
		ManageFooterPage managefooter = new ManageFooterPage(driver);
		managefooter.moreinfo();
		managefooter.editButton();
		String Address = ExcelUtility.getStringdata(1, 0, "FooterPage");
		String Email = ExcelUtility.getStringdata(1, 1, "FooterPage");
		String Phone = ExcelUtility.getStringdata(1, 2, "FooterPage");

		managefooter.updateAddress(Address);
		managefooter.updateEmail(Email);
		managefooter.updatePhone(Phone);
		managefooter.updatebutton();
		boolean message = managefooter.isalertDisplayed();
		Assert.assertTrue(message, Constant.Footer_Text_Updated_Successfully);

	}

}
