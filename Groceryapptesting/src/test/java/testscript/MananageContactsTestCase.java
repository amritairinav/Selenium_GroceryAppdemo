package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ManageCategoryPage;
import page.ManageContactsPage;
import utility.CommonLogin;
import utility.ExcelUtility;

public class MananageContactsTestCase extends Base {
	@Test(description = "verify if user is able to update contacts")
	public void updateContactinfo() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		CommonLogin login = new CommonLogin();
		login.login(driver, username, password);
		ManageContactsPage managecontactspage = new ManageContactsPage(driver);
		managecontactspage.moreinfo();
		managecontactspage.editButton();
		String Phone = ExcelUtility.getIntegerdata(1, 0, "ContactsPage");
		String Email = ExcelUtility.getStringdata(1, 1, "ContactsPage");
		String Address = ExcelUtility.getStringdata(1, 2, "ContactsPage");
		String DeliveryTime = ExcelUtility.getIntegerdata(1, 3, "ContactsPage");
		String DeliveryLimit = ExcelUtility.getIntegerdata(1, 4, "ContactsPage");
		managecontactspage.updatePhone(Phone);
		managecontactspage.updateEmail(Email);
		managecontactspage.updateAddress(Address);
		managecontactspage.deliveryTime(DeliveryTime);
		managecontactspage.deliveryLimit(DeliveryLimit);
		managecontactspage.updatebutton();
		boolean message = managecontactspage.isalertDisplayed();
		Assert.assertTrue(message);
	}

}
