package adminTC.ProductInfo;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import admin.ProductInfo.VerifyRequiredFieldValidations;
import commonUtility.Browser;

public class VerifyBlankValidations {
	VerifyRequiredFieldValidations object;
	
	@Test(priority=0)  				// Test case to open the browser and pass the url
	@Parameters({"valProductNameMessage","valSKUMessage","valProductCodeMessage","valOutOfStockMessage","valShippingCostMessage"})
	public void VerifyMessages(String valProductNameMessage, String valSKUMessage, String valProductCodeMessage, String valOutOfStockMessage, String valShippingCostMessage)
	{	
		object = PageFactory.initElements(Browser.webDriver,VerifyRequiredFieldValidations.class);
		
		object.Validations(valProductNameMessage, valSKUMessage, valProductCodeMessage, valOutOfStockMessage, valShippingCostMessage);
	}
}
