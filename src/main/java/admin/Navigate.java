package admin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.Browser;
import commonUtility.GlobalVariable;
import commonUtility.Wait;

public class Navigate {
	@FindBy(xpath = "//a[@data-test-selector='linkNavMenu']")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@data-test-selector='linkProducts']")
	private WebElement linkProducts;
	
	@FindBy(xpath = "//div[@id=\'loading-div-background\']")
	private WebElement loader;
	

	public void NavigateToProduct()
	{	
		//loadingWait(Browser.webDriver, loader);
		//Wait.EXPECT_NO_SPINNERS.apply(Browser.webDriver);
		menu.click();
		loadingWait(GlobalVariable.DelayLow);
		linkProducts.click();
		loadingWait(GlobalVariable.DelayLow);
		//loadingWait(Browser.webDriver, loader);
	}
	
	public void loadingWait(int wait) {
//		WebDriver driver, WebElement element
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to appear
//	    wait.until(ExpectedConditions.invisibilityOf(element)); // wait for loader to disappear
	    
	    Browser.webDriver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	

}
