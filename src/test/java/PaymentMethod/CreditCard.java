package PaymentMethod;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PaymentMethods.CreditCard.NavigateToPaymentMethods;
import PaymentMethods.CreditCard.VerifyLabelsAndValidations;
import admin.EditProduct;
import commonUtility.Browser;

public class CreditCard {

	NavigateToPaymentMethods nav;
	
	VerifyLabelsAndValidations labels;
	
	@Test(priority=0)  				
	public void NavigateToPaymentMethods()
	{	
		nav = PageFactory.initElements(Browser.webDriver, NavigateToPaymentMethods.class);
		nav.menuLinkVerification();
	}
	
	@Test(priority=1)  				
	public void VerifyLabels()
	{	
		labels = PageFactory.initElements(Browser.webDriver, VerifyLabelsAndValidations.class);
		labels.VerifyLabels();
	}
	
	
}
