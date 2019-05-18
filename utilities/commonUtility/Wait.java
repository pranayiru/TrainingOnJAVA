package commonUtility;


import java.time.Clock;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	static WebDriverWait exWait;

	
	public static final ExpectedCondition<Boolean> EXPECT_NO_SPINNERS = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver driver) {
	        Boolean loaded = true;
	        try {
	        List<WebElement> spinners = driver.findElements(By.id("loading-div-background"));
	        for (WebElement spinner : spinners) {
	            if (spinner.getAttribute("style")=="display: none;") {
	                loaded = false;
	                break;
	            }
	            if (spinner.isDisplayed()) {
	                loaded = false;
	                break;
	            }
	        }
	        }catch (Exception ex) {
	            loaded = false;
	        }
	        return loaded;

	    }
	};
	
	
	// To get the wait time and perform driver to stop till that time
	public static void implicitWait(int waitTimeMili) // Getting waitTimeMili wait time
	{
		Browser.webDriver.manage().timeouts().implicitlyWait(waitTimeMili, TimeUnit.SECONDS);
	}// End of wait implicitly 
	
	// No argument Explicit wait method to get the Explicit wait object (Default timeout is 60)
	public static WebDriverWait initializeExplicitWait()
	{
		int timeout = 60;
		if(exWait == null)
		{
			exWait = new WebDriverWait(Browser.webDriver,timeout);
		}
		return exWait;
	}// End of No argument Explicit wait method
	
	
	// Timeout argument  Explicit wait method to get the Explicit wait object (timeout is user provided)
	public static WebDriverWait initializeExplicitWait(int timeout)
	{
		if(exWait == null)
		{
			exWait = new WebDriverWait(Browser.webDriver, timeout);
		}
		return exWait;
	}// End of No Timeout argument Explicit wait method
	
	// Timeout  & Watch frequency arguments for Explicit wait method to get the Explicit wait object (timeout is user provided)
	public static WebDriverWait initializeExplicitWait(int timeout, int watchFrequency)
		{
			if(exWait == null)
			{
				exWait = new WebDriverWait(Browser.webDriver, timeout, watchFrequency);
			}
			return exWait;
		}// End of Timeout  & Watch frequency  Explicit wait method


	// All arguments for Explicit wait method to get the Explicit wait object (timeout is user provided)
	public static WebDriverWait initializeExplicitWait(Clock clock, Sleeper sleepObject, int timeout, int watchFrequency)
		{
			if(exWait == null)
			{
				exWait = new WebDriverWait(Browser.webDriver, clock, sleepObject, timeout, watchFrequency);
			}
			return exWait;
		}// End of All arguments  Explicit wait method		
	
	//Wait for background loader to be invisible
	public static void waitForLoader()
	{
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-div-background")));
	}// End of waiting for loader
		
}// End of DriverCapabilities
