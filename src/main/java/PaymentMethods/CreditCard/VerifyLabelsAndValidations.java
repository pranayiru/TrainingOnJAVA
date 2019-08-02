package PaymentMethods.CreditCard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import admin.ReadDataFile;
import commonUtility.Browser;
import commonUtility.GlobalVariable;
import commonUtility.Wait;

public class VerifyLabelsAndValidations {

	@FindBy(xpath = "//a[@data-test-selector='linkAddNew']")
	private WebElement linkAddNew;
	
	@FindBy(id = "ddlPaymentTypes")
	private WebElement drpPaymentTypes;
	
	@FindBy(xpath = "//a[@data-test-selector='linkSave']")
	private WebElement linkSave;
	
	@FindBy(xpath = "//*[@data-test-selector='txtPaymentName']")
	private WebElement PaymentName;
	
	@FindBy(xpath = "//*[@data-test-selector='txtDisplayOrder']")
	private WebElement txtDisplayOrder;
	
	@FindBy(xpath = "//*[@data-test-selector='chkDisplaySetting']")
	private WebElement chkDisplaySetting;
	
	ReadDataFile file = new ReadDataFile();
	
	public void VerifyLabels()
	{
		try {
			//Datafile where you will get all labels and blank validation of Payment Method 
			file.dataFile("LabelsAndValidations.xlsx"); 
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayHigh);
		
		wait.until(ExpectedConditions.visibilityOf(linkAddNew));
		
		linkAddNew.click();
		
		Wait.waitForLoader();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlPaymentTypes")));
		
		wait.until(ExpectedConditions.elementToBeClickable(linkSave));
		
		txtDisplayOrder.clear();
		
		linkSave.click();
		
//		verifyLabelsAndValidations("Payment Code" , "Payment Code is required.");
		
		verifyLabelsAndValidations(file.ReadFile("PaymentDisplayName", "Labels") , file.ReadFile("PaymentDisplayName", "Validations"));
		
		verifyLabelsAndValidations(file.ReadFile("MerchantLogin", "Labels") , file.ReadFile("MerchantLogin", "Validations"));
		
//		verifyLabelsAndValidations("Display Order" , "Enter Display Order");
		
//		verifyLabelsAndValidations("AcceptCard" , "Please select at least one accepted card type.");
		
		Select selectColumnValue = new Select(drpPaymentTypes);
		
		Assert.assertEquals(file.ReadFile("CreditCard", "Labels"), selectColumnValue.getFirstSelectedOption().getText());
		
		chkDisplaySetting.isSelected();
	}
	
	private void verifyLabelsAndValidations(String labels, String validations)
	{
		String objectLocatorForLable = "lbl" + labels.replaceAll("\\s", "");
		
		String objectLocatorForVal = "val" + labels.replaceAll("\\s", "");
		
		WebElement locator = Browser.webDriver.findElement(By.xpath("//*[@data-test-selector='"+objectLocatorForLable+"']"));
		
		String strLblPaymentName = locator.getText();
			
		Assert.assertEquals(strLblPaymentName, labels);
		
		locator = Browser.webDriver.findElement(By.xpath("//*[@data-test-selector='"+objectLocatorForVal+"']"));
		
		String strValPaymentName = locator.getText();
			
		Assert.assertEquals(strValPaymentName, validations);
	}
	
	
}
