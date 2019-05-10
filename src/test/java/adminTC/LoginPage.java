package adminTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import admin.Login;
import commonUtility.Browser;


public class LoginPage {
Login login;

	
	// Method to open the browser with URL
	@Test(priority=0)  				// Test case to open the browser and pass the url
	@Parameters({"browser","url"})
	public void openBrowser(String browser, String url)
	{	
		commonUtility.Browser.openBrowser(browser, url);
		System.out.println("browser opened");
		Browser.maximizeBrowser();
	}// End of Open browser test
			

	// To check the user log-in with new and existing user
	@Test(priority=2)			// Test case to all the details to the log-in page
	@Parameters({"username","password"})
	public void setLoginDetails(String username,String password)
	{
		login = PageFactory.initElements(Browser.webDriver,Login.class);
		login.setLoginDetails(username, password);
		login.clickLogin();
	}// End of details page
	
	/*@Test(priority=3)
	public void clickLaterButton()
	{
		login.laterButtonPopUp();
	}*/
}
