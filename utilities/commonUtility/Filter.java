package commonUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import admin.Login;


public class Filter {
	Wait waitForLoader;

	
	@FindBy(xpath = "//a[@data-test-selector='linkFilter']")
	private WebElement linkFilter;
	
	@FindBy(xpath = "(//select[@data-test-selector='drpColumnList'])[2]")
	private WebElement drpColumnList;
	
	@FindBy(xpath = "(//select[@data-test-selector='drpOptionList'])[2]")
	private WebElement drpOptionList;
	
	@FindBy(xpath = "(//*[@id=\"filtercolumn\"])[2]")
	private WebElement txtFilterInput;

	@FindBy(xpath = "//*[@data-test-selector='popBtnApplyFilter']")
	private WebElement popBtnApplyFilter;
	
	public void typeOfFilter(String filterType, String columnValue, String optionValue, String filterInput)
	{
		if(filterType.equalsIgnoreCase("ListPage"))
		{
			ApplyListPageFilter(columnValue, optionValue, filterInput);
		}
		
		else if(filterType.equalsIgnoreCase("PopUpPage"))
		{
			ApplyPopUpPageFilter(columnValue, optionValue, filterInput);
		}
	}
	
	private void ApplyListPageFilter(String columnValue, String optionValue, String filterInput)
	{
		try {
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.elementToBeClickable(linkFilter));
		
		linkFilter.click();
		
		wait.until(ExpectedConditions.visibilityOf(drpColumnList));
		
		SelectOption(drpColumnList, columnValue);
		
		SelectOption(drpOptionList, optionValue);
		
		txtFilterInput.sendKeys(filterInput);
		
		popBtnApplyFilter.click();
		
		waitForLoader.waitForLoader();
		}
		
		catch(NullPointerException ex)
		{
			 ex.getMessage();
		}
	}
	
	private void ApplyPopUpPageFilter(String columnValue, String optionValue, String filterInput)
	{
		
	}
	
	private void SelectOption(WebElement webElement, String optionToBeSelected)
	{
		Select selectColumnValue = new Select(webElement);
		
		selectColumnValue.selectByVisibleText(optionToBeSelected);
	}
}
