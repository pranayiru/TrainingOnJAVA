package loginlanding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{

	@FindBy(xpath = "//input[@id='btnUsername']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='btnPassword']")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[@id='Login']")
	private WebElement login;

	// Method for the new user log-in details set-up
	public void setLoginDetails(String username,String password)
	{
		userName.click();
		userName.sendKeys(username);
		
		passWord.click();
		passWord.sendKeys(password);
		
	}// End of setLoginDetails

	// Method for log-in
	public void clickLogin()
	{
		login.click();
		
	}// End of clickLogin
	
}// End of class LoginObjects
