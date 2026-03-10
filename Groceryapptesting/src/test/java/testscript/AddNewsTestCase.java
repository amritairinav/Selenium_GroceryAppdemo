package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import page.LoginPage;
import page.ManageNewsPage;

public class AddNewsTestCase extends Base { 

	@Test
	public void addNews() {
		new CommonLogin(driver,"admin","admin");
		ManageNewsPage news = new ManageNewsPage(driver);
		news.moreinfo();
		news.newbutton();
		String newstextarea1 = "Original News";
		news.newstextarea(newstextarea1);
		news.savebutton();
		boolean message = news.isalertdisplayed();
		Assert.assertTrue(message);
}
	
}

