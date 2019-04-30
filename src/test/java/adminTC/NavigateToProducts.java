package adminTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonUtility.Browser;
import admin.Navigate;;

public class NavigateToProducts {

	Navigate navigate;
	
	@Test(priority=1)
	public void Navigate()
	{
		navigate = PageFactory.initElements(Browser.webDriver,Navigate.class);
		navigate.NavigateToProduct();
	}
	
}
