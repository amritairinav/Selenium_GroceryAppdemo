package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import Utility.ExcelUtility;
import Utility.FakerUtility;
import page.AdminUserPage;

public class AdminUserTestCase extends Base {
	@Test
	public void addAdminuserInfo() throws IOException {
		String username1 = ExcelUtility.getStringdata(1, 0,"LoginPage");
		String password1 = ExcelUtility.getStringdata(1, 1,"LoginPage");
		new CommonLogin(driver,username1,password1);
		AdminUserPage adminuser=new AdminUserPage(driver);
        adminuser.moreinfo();
        adminuser.newbutton();
        String username2 = ExcelUtility.getStringdata(1, 0,"AdminPage");
		String password2 = ExcelUtility.getStringdata(1, 1,"AdminPage");
        adminuser.enterusername(username2);
        adminuser.enterpassword(password2);
        String dropdown=ExcelUtility.getStringdata(1, 2,"AdminPage");
        adminuser.dropdown(dropdown);
        adminuser.savebutton();
        boolean message = adminuser.isalertdisplayed();
		Assert.assertTrue(message);
        

	}
    }


