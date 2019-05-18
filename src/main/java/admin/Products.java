package admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.Browser;
import commonUtility.Save;
import commonUtility.GlobalVariable;
public class Products {

	@FindBy(xpath = "//a[@data-test-selector='btnAddNew']")
	private WebElement addNew;
	
	@FindBy(xpath = "//a[@id=\"btnSaveNDraft\"]")
	private WebElement saveAsDraft;

	@FindBy(xpath = "//div[@id='loading-div-background']")
	private WebElement loader;
	
	@FindBy(xpath = "//button[@data-test-selector='btnToggle']")
	private static WebElement btnToggle;
	
	@FindBy(xpath = "//a[@data-test-selector='linkSaveNClose']")
	private static WebElement btnSaveNClose;
	
	DateFormat dateFormat = new SimpleDateFormat("HHmmss");

	 //get current date time with Date()
	 Date date = new Date();

	 // Now format the date
	 String date1= dateFormat.format(date);
	 
	 Actions actions = new Actions(Browser.webDriver);
	
	public void AddNewProduct()
	{
		addNew.click();
		
		waitForLoader();
		//loadingWait(Browser.webDriver, loader);
//		loadingWait(GlobalVariable.DelayMedium);
		
		WebElement selectProductType = Browser.webDriver.findElement(By.xpath("//select[@data-test-selector='drpProductType']"));
		
		Select SelectProductType = new Select(selectProductType);
		
		SelectProductType.selectByValue("BundleProduct");
		
		//loadingWait(Browser.webDriver, loader);
		waitForLoader();
		
		saveAsDraft.click();
		
		GlobalVariable.productName = "Automation" + date1;
		
		Browser.webDriver.findElement(By.xpath("//input[@data-test-selector='txtProductName']")).sendKeys(GlobalVariable.productName);
		
		Browser.webDriver.findElement(By.xpath("//input[@data-test-selector='txtSKU']")).sendKeys("Automation" + date1);
		
		Browser.webDriver.findElement(By.xpath("//input[@data-test-selector='txtProductCode']")).sendKeys("Automation" + date1);
		
		WebElement selectOutOfStockOption = Browser.webDriver.findElement(By.xpath("//select[@data-test-selector='drpOutOfStockOptions']"));
		
		WebElement UOM = Browser.webDriver.findElement(By.xpath("//*[@data-test-selector='drpUOM']"));

//		actions.moveToElement(selectOutOfStockOption);
		
		((JavascriptExecutor) Browser.webDriver).executeScript("arguments[0].scrollIntoView(true);", UOM);
//		Thread.sleep(500);
		
		actions.perform();
		 
		Select outOfStockOp = new Select(selectOutOfStockOption);
		
		outOfStockOp.selectByValue("DontTrackInventory");
		
		WebElement selectShippingCost = Browser.webDriver.findElement(By.xpath("//*[@data-test-selector=\"drpShippingcost\" or @data-test-selector=\"drpShippingCostRules\"]"));
		
		actions.moveToElement(selectShippingCost);
		
		actions.perform();
		
		Select shippingCost = new Select(selectShippingCost);
		
		shippingCost.selectByValue("QuantityBasedRate");
		
		clickSaveAndClose();
		
		waitForLoader();
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
