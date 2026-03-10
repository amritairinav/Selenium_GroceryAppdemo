package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import page.LoginPage;
import page.Logoutpage;

public class LogoutTestCase extends Base {

	@Test 
	public void logout() {
		new CommonLogin(driver,"admin","admin");
		Logoutpage logout = new Logoutpage(driver);
        logout.admin();
        logout.logout();
        boolean field = logout.isusernamedisplayed();
		Assert.assertTrue(field);

	}
}
