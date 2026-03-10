package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.CommonLogin;
import page.ManageCategoryPage;

public class ManageCategoryTestcase extends Base {
	@Test
	public void manageCategory() {
		new CommonLogin(driver,"admin","admin");
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.moreinfo();
		managecategorypage.newbutton();
		String Category="Ocean";
		managecategorypage.enterCategory(Category);
		managecategorypage.clickList();
		managecategorypage.uploadAdminImage();
		managecategorypage.savebutton();
		boolean message = managecategorypage.isalertdisplayed();
		Assert.assertTrue(message);
	}
	
	

}
