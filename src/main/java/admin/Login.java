package admin;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonUtility.Browser;
import commonUtility.GlobalVariable;
import commonUtility.Wait;

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
		
		waitForLoader();
		
	}// End of clickLogin
	
	public void laterButtonPopUp()
	{
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Invoke.webDriver)							
//				.withTimeout(30, TimeUnit.SECONDS) 			
//				.pollingEvery(5, TimeUnit.SECONDS) 			
//				.ignoring(NoSuchElementException.class);
		
//		Browser.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(2000);
		
			if(Browser.webDriver.findElement(By.xpath("//button[@id='Later']")).isDisplayed())
			{
				WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
				
				wait.until(ExpectedConditions.elementToBeClickable(later)); 
				
//				Browser.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				later.click();
		
				waitForLoader();
			}	
		}
		
		catch(NullPointerException ex)
		{
			ex.getMessage();
		}
		
		catch(NoSuchElementException ex)
		{
			ex.getMessage();
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void waitForLoader()
	{
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-div-background")));
	}
	
}
