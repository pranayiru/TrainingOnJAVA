package admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.Browser;
import commonUtility.GlobalVariable;
import commonUtility.Save;
import commonUtility.Wait;

public class EditProduct {
	
	@FindBy(xpath = "//a[@class=\"z-edit\"]")
	private WebElement linkListPageEdit;
	
	@FindBy(xpath = "//select[@data-test-selector=\"drpTshirtColor\"]")
	private WebElement drpTshirtColor;
	
	@FindBy(xpath = "//select[@data-test-selector=\"drpTshirtSize\"]")
	private WebElement drpTshirtSize;
	
	@FindBy(xpath = "//select[@data-test-selector=\"drpTShirtMaterial\"]")
	private WebElement drpTShirtMaterial;
	
	@FindBy(xpath = "//select[@data-test-selector=\"drpTshirtVendor\"]")
	private WebElement drpTshirtVendor;
	
	@FindBy(xpath = "//*[text() = 'Product Details ']")
	private WebElement tabProductDetails;
	
	@FindBy(id="LongDescription_15_0_0_1_attr_ifr")
	private WebElement iframeLongDescription;
	
	@FindBy(id="ShortDescription_14_0_0_1_attr_ifr")
	private WebElement iframeShortDescription;
	
	@FindBy(id="ProductSpecification_34_0_0_1_attr_ifr")
	private WebElement iframeProductSpecification;
	
	@FindBy(id="FeatureDescription_33_0_0_1_attr_ifr")
	private WebElement iframeFeatureDescription;
	
	@FindBy(id="tinymce")
	private WebElement txtIframeInput;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpBrand\"]")
	private WebElement drpBrand;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpVendor\"]")
	private WebElement drpVendor;
	
	@FindBy(xpath="(//*[@class=\"fstControls\"]/input)[2]")
	private WebElement inputHighlights;
	
	@FindBy(xpath="//*[@class=\"fstResults\"]/span")
	private WebElement highlightSearchResult;
	
	@FindBy(xpath="//*[text() = \"Image \"]")
	private WebElement tabImage;
	
	@FindBy(xpath="//*[@data-test-selector=\"imgProductImage\"]")
	private WebElement imgProductImage;
	
	@FindBy(xpath="(//*[@class=\"tile-view-container\"]//img)[1]")
	private WebElement imgSelectFirstProductImage;
	
	@FindBy(xpath="//*[text() = \"Product Setting \"]")
	private WebElement tabProductSetting;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpUOM\"]")
	private WebElement drpUOM;
	
	@FindBy(xpath="//*[@data-test-selector=\"txtMinimumQuantity\"]")
	private WebElement txtMinimumQuantity;
	
	@FindBy(xpath="//*[@data-test-selector=\"txtMaximumQuantity\"]")
	private WebElement txtMaximumQuantity;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpOutOfStockOptions\"]")
	private WebElement drpOutOfStockOptions;
	
	@FindBy(xpath="//*[text() = \"Shipping Settings \"]")
	private WebElement tabShippingSettings;
	
	@FindBy(xpath="(//*[@id=\"ShippingSettings1\"]//div/label)[2]")
	private WebElement radioFreeShippingYes;
	
	@FindBy(xpath="(//*[@id=\"ShippingSettings1\"]//div/label)[3]")
	private WebElement radioFreeShippingNo;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpShippingcost\"]")
	private WebElement drpShippingcost;
	
	@FindBy(id="ShippingInformation_36_0_0_1_attr_ifr")
	private WebElement iframeShippingInformation;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpContainer\"]")
	private WebElement drpContainer;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpPackageSizeFromRequest\"]")
	private WebElement drpPackageSizeFromRequest;
	
	@FindBy(xpath="//*[@data-test-selector=\"drpPackagingType\"]")
	private WebElement drpPackagingType;
	
	@FindBy(xpath = "//button[@data-test-selector='btnToggle']")
	private static WebElement btnToggle;
	
	@FindBy(xpath = "//a[@data-test-selector='linkSaveNClose']")
	private static WebElement btnSaveNClose;
	
	public void ClickOnEditLink()
	{
		linkListPageEdit.click();
		
		Wait.waitForLoader();
	}
	
	public void AddProductDetails()
	{
//		ProductInfo();
		
		ProductDetails();
		
		Image();
		
		ProductSettings();
		
		ShippingSetting();
		
		clickSaveAndClose();
	}

	private void ProductInfo()
	{
		SelectOptionByIndex(drpTshirtColor, 1);
		
		SelectOptionByIndex(drpTshirtSize, 1);
		
		SelectOptionByIndex(drpTShirtMaterial, 1);
		
		SelectOptionByIndex(drpTshirtVendor, 1);
	}
	
	private void ProductDetails()
	{
		tabProductDetails.click();
		
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.visibilityOf(iframeLongDescription));
		
		SetTextToIframe(iframeLongDescription, "Nice Product");
		
		SetTextToIframe(iframeShortDescription, "Nice Product");
		
		SetTextToIframe(iframeProductSpecification, "Nice Product");
		
		SetTextToIframe(iframeFeatureDescription, "Nice Product");
		
		SelectOptionByIndex(drpBrand, 1);
		
		SelectOptionByIndex(drpVendor, 1);
		
		MultiSelect("USDA Certified");
		
		MultiSelect("BIO Certified");
		
		MultiSelect("Free Shipping");
	}
	
	private void Image()
	{
		tabImage.click();
		
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.visibilityOf(imgProductImage));
		
		imgProductImage.click();
		
		wait.until(ExpectedConditions.visibilityOf(imgSelectFirstProductImage));
		
		imgSelectFirstProductImage.click();
		
		Wait.waitForLoader();
	}
	
	private void ProductSettings()
	{
		tabProductSetting.click();
		
		SelectOptionByIndex(drpUOM, 1);
		
		txtMinimumQuantity.clear();
		
		txtMinimumQuantity.sendKeys("10");
		
		txtMaximumQuantity.clear();
		
		txtMaximumQuantity.sendKeys("100");
		
		SelectOptionByValue(drpOutOfStockOptions, "AllowBackOrdering");
	}
	
	
	private void ShippingSetting()
	{
		tabShippingSettings.click();
		
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.visibilityOf(radioFreeShippingYes));
		
		radioFreeShippingYes.click();
		
		SelectOptionByValue(drpShippingcost, "QuantityBasedRate");
		
		SetTextToIframe(iframeShippingInformation, "Free Shipping");
		
		SelectOptionByIndex(drpContainer, 1);
		
		SelectOptionByIndex(drpPackageSizeFromRequest, 1);
		
		SelectOptionByIndex(drpPackagingType, 1);
	}
	
	private void SelectOptionByIndex(WebElement webElement, int optionToBeSelected)
	{
		Select selectColumnValue = new Select(webElement);
		
		selectColumnValue.selectByIndex(optionToBeSelected);
	}
	
	private void SelectOptionByValue(WebElement webElement, String optionToBeSelected)
	{
		Select selectColumnValue = new Select(webElement);
		
		selectColumnValue.selectByValue(optionToBeSelected);
	}
	
	private void SetTextToIframe(WebElement webElement, String inputText)
	{
		Browser.webDriver.switchTo().frame(webElement);
		
		txtIframeInput.sendKeys(inputText);
		
		Browser.webDriver.switchTo().defaultContent();
	}
	
	private void MultiSelect(String inputText)
	{
		inputHighlights.clear();
		
		inputHighlights.sendKeys(inputText);
		
		highlightSearchResult.click();
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


