package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import page.HomePage;
import page.LoginPage;
import page.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTestCase extends Base {
	public HomePage homepage;
	public ManageNewsPage managenewspage;
	
	@Test(description = "Verify if the user is able to add news and save",groups = {
	"Regression" }, retryAnalyzer = retry.Retry.class)
	public void addNews() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheusername(username).enterThepassword(password).checkthCheckboxrememberme();
		homepage=loginpage.clickSignin();
		managenewspage=homepage.manageNewsmoreinfo();
		String newstextarea = ExcelUtility.getStringdata(1, 0, "NewsPage");
	    managenewspage.newbutton().newsTextarea(newstextarea).savebutton();
		boolean message = managenewspage.isalertdisplayed();
		Assert.assertTrue(message, Constant.NEWS_ADDED_SUCCESSFULLY);
	}

}
