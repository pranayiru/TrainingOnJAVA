package PaymentMethods.CreditCard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commonUtility.Wait;

public class NavigateToPaymentMethods {
	
	@FindBy(xpath = "//a[@data-test-selector='linkNavMenu']")
	private WebElement linkNavMenu;
	
	@FindBy(xpath = "//a[@data-test-selector='linkPaymentMethods']")
	private WebElement linkPaymentMethods;
	
	public void menuLinkVerification()
	{
		linkNavMenu.click();
		
		linkPaymentMethods.isDisplayed();
		
		String strPaymentMethod = linkPaymentMethods.getText();
		
		Assert.assertEquals(strPaymentMethod, "Payment Methods");
		
		linkPaymentMethods.click();
		
		Wait.waitForLoader();
	}

}
