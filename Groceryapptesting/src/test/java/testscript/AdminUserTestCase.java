package testscript;

import org.testng.annotations.Test;

import Utility.CommonLogin;
import page.AdminUserPage;

public class AdminUserTestCase extends Base {
	@Test
	public void addAdminuserInfo() {
		new CommonLogin(driver,"admin","admin");
		AdminUserPage adminuser=new AdminUserPage(driver);
        adminuser.moreinfo();
        adminuser.newbutton();
        String username2 = "Amrita1";
		String password2= "test!!";
        adminuser.enterusername(username2);
        adminuser.enterpassword(password2);
        adminuser.dropdown();
        adminuser.savebutton();
        

	}
    }


