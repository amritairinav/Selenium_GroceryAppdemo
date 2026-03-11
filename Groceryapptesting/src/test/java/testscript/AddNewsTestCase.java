package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import Utility.ExcelUtility;
import page.LoginPage;
import page.ManageNewsPage;

public class AddNewsTestCase extends Base { 

	@Test
	public void addNews() throws IOException {
		String username1 = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password1 = ExcelUtility.getStringdata(1, 1, "LoginPage");
		new CommonLogin(driver,username1,password1);
		ManageNewsPage news = new ManageNewsPage(driver);
		news.moreinfo();
		news.newbutton();
		String newstextarea1 = ExcelUtility.getStringdata(1, 0, "NewsPage");
		news.newstextarea(newstextarea1);
		news.savebutton();
		boolean message = news.isalertdisplayed();
		Assert.assertTrue(message);
}
	
}

