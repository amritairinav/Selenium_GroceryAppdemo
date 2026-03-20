package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageFooterPage;
import utility.ExcelUtility;

public class ManageFooterTestCase extends Base {

	public HomePage homepage;
	public ManageFooterPage managefooterpage;

	@Test(description = "Verify if user is able to update footer informations", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)

	public void updateFooterinformations() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username).enterThepassword(password).checkthCheckboxrememberme();
		homepage = loginpage.clickSignin();
		String Address = ExcelUtility.getStringdata(1, 0, "FooterPage");
		String Email = ExcelUtility.getStringdata(1, 1, "FooterPage");
		String Phone = ExcelUtility.getStringdata(1, 2, "FooterPage");
		managefooterpage = homepage.manageFootermoreinfo().editButton().updateAddress(Address).updateEmail(Email)
				.updatePhone(Phone).updatebutton();
		boolean message = managefooterpage.isalertDisplayed();
		Assert.assertTrue(message, Constant.Footer_Text_Updated_Successfully);

	}

}
