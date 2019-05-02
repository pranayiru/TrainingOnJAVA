package admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonUtilities.Browser;

public class Login {

	@FindBy(xpath = "//input[@id='btnUsername']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='btnPassword']")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[@id='Login']")
	private WebElement login;
	
	//For POP UP
	@FindBy(xpath="//div[@class='modal-content']")
	private WebElement popUp;
	
	@FindBy(xpath="//button[@id='Later']")
	private WebElement later;

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
	
	public void laterButtonPopUp()
	{
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Invoke.webDriver)							
//				.withTimeout(30, TimeUnit.SECONDS) 			
//				.pollingEvery(5, TimeUnit.SECONDS) 			
//				.ignoring(NoSuchElementException.class);
		
		Browser.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		later.click();

	}
}
