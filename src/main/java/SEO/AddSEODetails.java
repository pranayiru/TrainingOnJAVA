package SEO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.Browser;
import commonUtility.GlobalVariable;
import commonUtility.Wait;

public class AddSEODetails {
	
	@FindBy(id="PortalId")
	private WebElement drpAssociatedStore;
	
	@FindBy(xpath = "//a[@data-test-selector=\"linkSEO\"]")
	private WebElement linkSEO;
	
	@FindBy(xpath = "//input[@data-test-selector=\"txtSEOTitle\"]")
	private WebElement txtSEOTitle;
	
	@FindBy(xpath = "//input[@data-test-selector=\"txtSEODescription\"]")
	private WebElement txtSEODescription;
	
	@FindBy(id="SEOKeywords")
	private WebElement txtSEOKeywords;
	
	@FindBy(xpath = "//input[@data-test-selector=\"txtSEOUrl\"]")
	private WebElement txtSEOUrl;
	
	@FindBy(xpath = "//input[@data-test-selector=\"txtIsRedirect\"]")
	private WebElement chkIsRedirect;
	
	@FindBy(xpath = "//button[@data-test-selector=\"btnSaveSeo\"]")
	private WebElement btnSaveSeo;
	
	@FindBy(xpath = "//a[@class=\"z-edit\"]")
	private WebElement linkListPageEdit;
	
	public void setSEODetails()
	{
		if(linkListPageEdit.isDisplayed())
		{
			linkListPageEdit.click();
			
			Wait.waitForLoader();
		}
		
		linkSEO.click();
		
		Wait.waitForLoader();
		
		Select selectColumnValue = new Select(drpAssociatedStore);
			
		selectColumnValue.selectByVisibleText("AutomationStore");
		
		txtSEOTitle.sendKeys("Automation Bundle Product");
		
		txtSEODescription.sendKeys(GlobalVariable.productName);
		
		txtSEOKeywords.sendKeys(GlobalVariable.productName);
		
		txtSEOUrl.sendKeys("Bundle-" + GlobalVariable.productName);
		
		btnSaveSeo.click();
		
		waitForLoader();
		
	}
	
	private void waitForLoader()
	{
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-div-background")));
	}
}
