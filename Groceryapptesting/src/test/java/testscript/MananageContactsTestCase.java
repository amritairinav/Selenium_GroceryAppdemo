package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageContactsPage;
import utility.ExcelUtility;

public class MananageContactsTestCase extends Base {

	public HomePage homepage;
	public ManageContactsPage managecontactspage;

	@Test(description = "verify if user is able to update contacts", groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class)
	public void updateContactinfo() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username).enterThepassword(password).checkthCheckboxrememberme();
		homepage = loginpage.clickSignin();
		managecontactspage = homepage.manageContactmoreinfo();
		String Phone = ExcelUtility.getIntegerdata(1, 0, "ContactsPage");
		String Email = ExcelUtility.getStringdata(1, 1, "ContactsPage");
		String Address = ExcelUtility.getStringdata(1, 2, "ContactsPage");
		String DeliveryTime = ExcelUtility.getIntegerdata(1, 3, "ContactsPage");
		String DeliveryLimit = ExcelUtility.getIntegerdata(1, 4, "ContactsPage");
		managecontactspage.editButton().updatePhone(Phone).updateEmail(Email).updateAddress(Address)
				.deliveryTime(DeliveryTime).deliveryLimit(DeliveryLimit).updatebutton();
		boolean message = managecontactspage.isalertDisplayed();
		Assert.assertTrue(message, Constant.Contact_Updated_Successfully);
	}

}
