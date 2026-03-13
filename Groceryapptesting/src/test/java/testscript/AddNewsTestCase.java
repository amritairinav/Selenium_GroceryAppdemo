package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ManageNewsPage;
import utility.CommonLogin;
import utility.ExcelUtility;

public class AddNewsTestCase extends Base {

	@Test(description = "Verify if the user is able to add news and save")
	public void addNews() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");
		CommonLogin login = new CommonLogin();
		login.login(driver, username, password);
		ManageNewsPage news = new ManageNewsPage(driver);
		news.moreinfo();
		news.newbutton();
		String newstextarea = ExcelUtility.getStringdata(1, 0, "NewsPage");
		news.newsTextarea(newstextarea);
		news.savebutton();
		boolean message = news.isalertdisplayed();
		Assert.assertTrue(message);
	}

}
