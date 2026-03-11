package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import Utility.ExcelUtility;
import page.ManageCategoryPage;

public class ManageCategoryTestcase extends Base {
	@Test
	public void manageCategory() throws IOException {
		String username1 = ExcelUtility.getStringdata(1, 0,"LoginPage");
		String password1 = ExcelUtility.getStringdata(1, 1,"LoginPage");
		new CommonLogin(driver,username1,password1);
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.moreinfo();
		managecategorypage.newbutton();
		String Category=ExcelUtility.getStringdata(1, 0,"CategoryPage");
		managecategorypage.enterCategory(Category);
		managecategorypage.clickList();
		managecategorypage.uploadAdminImage();
		managecategorypage.savebutton();
		boolean message = managecategorypage.isalertdisplayed();
		Assert.assertTrue(message);
	}
	
	

}
