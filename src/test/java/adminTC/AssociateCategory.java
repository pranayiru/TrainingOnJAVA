package adminTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import admin.Category;
import admin.Navigate;
import commonUtility.Browser;

public class AssociateCategory {

Category category;
	
	@Test(priority=1)
	public void Category()
	{
		category = PageFactory.initElements(Browser.webDriver,Category.class);
		category.associateCategory();
	}
}
