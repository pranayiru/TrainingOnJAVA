package admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.Browser;
public class Products {

	@FindBy(xpath = "//a[@data-test-selector='btnAddNew']")
	private WebElement addNew;
	
	@FindBy(xpath = "//a[@id='btnSaveNDraft']")
	private WebElement saveAsDraft;

	@FindBy(xpath = "//div[@id='loading-div-background']")
	private WebElement loader;
	
	DateFormat dateFormat = new SimpleDateFormat("HHmmss");

	 //get current date time with Date()
	 Date date = new Date();

	 // Now format the date
	 String date1= dateFormat.format(date);
	 
	 Actions actions = new Actions(Browser.webDriver);
	
	public void AddNewProduct()
	{
		addNew.click();
		
		//loadingWait(Browser.webDriver, loader);
		loadingWait(7);
		
		WebElement selectProductType = Browser.webDriver.findElement(By.xpath("//select[@data-test-selector='drpProductType']"));
		
		Select SelectProductType = new Select(selectProductType);
		
		SelectProductType.selectByValue("GroupedProduct");
		
		//loadingWait(Browser.webDriver, loader);
		loadingWait(7);
		
		saveAsDraft.click();
		
		Browser.webDriver.findElement(By.xpath("//input[@data-test-selector='txtProductName']")).sendKeys("Automation" + date1);
		
		Browser.webDriver.findElement(By.xpath("//input[@data-test-selector='txtSKU']")).sendKeys("Automation" + date1);
		
		Browser.webDriver.findElement(By.xpath("//input[@data-test-selector='txtProductCode']")).sendKeys("Automation" + date1);
		
		WebElement selectOutOfStockOption = Browser.webDriver.findElement(By.xpath("//select[@data-test-selector='drpOutOfStockOptions']"));
		
//		actions.moveToElement(selectOutOfStockOption);
		
		((JavascriptExecutor) Browser.webDriver).executeScript("arguments[0].scrollIntoView(true);", selectOutOfStockOption);
//		Thread.sleep(500);
		
		actions.perform();
		 
		Select outOfStockOp = new Select(selectOutOfStockOption);
		
		outOfStockOp.selectByValue("DontTrackInventory");
		
		WebElement selectShippingCost = Browser.webDriver.findElement(By.xpath("//select[@data-test-selector='drpShippingCostRules']"));
		
		actions.moveToElement(selectShippingCost);
		
		actions.perform();
		
		Select shippingCost = new Select(selectShippingCost);
		
		shippingCost.selectByValue("QuantityBasedRate");
		
		saveAsDraft.click();
	}

	
	public void loadingWait(int wait) {
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to appear
//	    wait.until(ExpectedConditions.invisibilityOf(element)); // wait for loader to disappear
	    
	    Browser.webDriver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

}
