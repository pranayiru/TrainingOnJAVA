package admin.ProductInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.Browser;
import commonUtility.GlobalVariable;
import commonUtility.Save;
import commonUtility.Wait;

public class VerifyRequiredFieldValidations {
	
	@FindBy(id="ProductName_11_0_0_1_attr-error")
	private WebElement valProductName;
	
	@FindBy(id="SKU_12_0_0_1_attr-error")
	private WebElement valSKU;
	
	@FindBy(id="ProductCode_13_0_0_1_attr-error")
	private WebElement valProductCode;
	
	@FindBy(id="OutOfStockOptions_31_18_0_1_attr-error")
	private WebElement valOutOfStockOptions;
	
	@FindBy(id="Shippingcost_208_200_0_1_attr-error")
	private WebElement valShippingCost;
	
	@FindBy(xpath = "//a[@data-test-selector='btnAddNew']")
	private WebElement addNew;
	
	@FindBy(xpath = "//button[@data-test-selector='btnToggle']")
	private WebElement btnToggle;
	
	@FindBy(xpath = "//a[@data-test-selector='linkSaveNClose']")
	private WebElement btnSaveNClose;
	
	public void Validations(String valProductNameMessage, String valSKUMessage, String valProductCodeMessage, String valOutOfStockMessage, String valShippingCostMessage)
	{
		addNew.click();
		
//		waitForLoader();
		Wait.waitForLoader();
		
		Save.clickSaveAndClose();
		
		valProductName.isDisplayed();
		
		valProductName.getText().equalsIgnoreCase(valProductNameMessage);
		
		valSKU.isDisplayed();
		
		valSKU.getText().equalsIgnoreCase(valSKUMessage);
		
		valProductCode.isDisplayed();
		
		valProductCode.getText().equalsIgnoreCase(valProductCodeMessage);
		
		valOutOfStockOptions.isDisplayed();
		
		valOutOfStockOptions.getText().equalsIgnoreCase(valOutOfStockMessage);

		valOutOfStockOptions.isDisplayed();
		
		valOutOfStockOptions.getText().equalsIgnoreCase(valShippingCostMessage);
	}
	
	public void waitForLoader()
	{
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-div-background")));
	}
	
	private void clickSaveAndClose()
	{
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.elementToBeClickable(btnToggle)); 
		
		btnToggle.click();
		
		wait.until(ExpectedConditions.visibilityOf(btnSaveNClose)); 
		
		btnSaveNClose.click();
	}
}
	
	