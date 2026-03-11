package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import Utility.ExcelUtility;
import page.LoginPage;
import page.Logoutpage;

public class LogoutTestCase extends Base {

	@Test 
	public void logout() throws IOException {
		String username1 = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringdata(1, 1, "LoginPage");
		new CommonLogin(driver,username1,password1);
		Logoutpage logout = new Logoutpage(driver);
        logout.admin();
        logout.logout();
        boolean field = logout.isusernamedisplayed();
		Assert.assertTrue(field);

	}
}
