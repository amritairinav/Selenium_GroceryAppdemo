package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.Logoutpage;
import page.ManageNewsPage;

public class Testcases extends Base {

	@Test (priority=1)
	public void LoginandAddNews() {

		String username1 = "admin";
		String password1 = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.entertheusername(username1);
		loginpage.enterthepassword(password1);
		loginpage.checkthecheckboxrememberme();
		loginpage.clicksignin();
		ManageNewsPage news = new ManageNewsPage(driver);
		news.moreinfo();
		news.newbutton();
		String newstextarea1 = "Original News";
		news.newstextarea(newstextarea1);
		news.savebutton();
		boolean message = news.isalertdisplayed();
		Assert.assertTrue(message);
	}
	
	@Test (priority=2)
	public void Logout() {
		String username1 = "admin";
		String password1 = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.entertheusername(username1);
		loginpage.enterthepassword(password1);
		loginpage.checkthecheckboxrememberme();
		loginpage.clicksignin();
		Logoutpage logout = new Logoutpage(driver);
        logout.admin();
        logout.logout();
        boolean field = logout.isusernamedisplayed();
		Assert.assertTrue(field);

	}

    }

