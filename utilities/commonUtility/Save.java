package commonUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Save {
	
	@FindBy(xpath = "//button[@data-test-selector='btnToggle']")
	private static WebElement btnToggle;
	
	@FindBy(xpath = "//a[@data-test-selector='linkSaveNClose']")
	private static WebElement btnSaveNClose;
	
	public static void clickSaveAndClose()
	{
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.elementToBeClickable(btnToggle)); 
		
		btnToggle.click();
		
		wait.until(ExpectedConditions.visibilityOf(btnSaveNClose)); 
		
		btnSaveNClose.click();
	}
}
