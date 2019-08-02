package commonUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filter {
	
	@FindBy(xpath = "(//a[@data-test-selector='linkFilter'])[1]")
	private WebElement linkFilter;
	
	@FindBy(xpath = "(//select[@data-test-selector='drpColumnList'])[2]")
	private WebElement drpColumnList;
	
	@FindBy(xpath = "(//select[@data-test-selector='drpOptionList'])[2]")
	private WebElement drpOptionList;
	
	@FindBy(xpath = "(//*[@id=\"filtercolumn\"])[2]")
	private WebElement txtFilterInput;

	@FindBy(xpath = "(//*[@data-test-selector='popBtnApplyFilter'])[1]")
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
	
	private void ApplyPopUpPageFilter(String columnValue, String optionValue, String filterInput) {
		// TODO Auto-generated method stub
		try {
				WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-test-selector='linkFilter'])[2]")));

				WebElement linkFilter = Browser.webDriver.findElement(By.xpath("(//a[@data-test-selector='linkFilter'])[2]"));
				
				linkFilter.click();
				
				wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("(//select[@data-test-selector='drpColumnList'])[1]")));
				
				SelectOption((WebElement) By.xpath("(//select[@data-test-selector='drpColumnList'])[1]"), columnValue);
				
				Thread.sleep(1500);
				
				SelectOption((WebElement) By.xpath("(//select[@data-test-selector='drpOptionList'])[1]"), optionValue);
				
				Thread.sleep(1500);
				
				WebElement filterColumn = Browser.webDriver.findElement(By.xpath("(//*[@id=\\\"filtercolumn\\\"])[1]"));
				
				filterColumn.sendKeys(filterInput);
				
				Thread.sleep(1500);
				
				WebElement popBtnApplyFilter = Browser.webDriver.findElement(By.xpath("(//*[@data-test-selector='popBtnApplyFilter'])[2]"));
				
				popBtnApplyFilter.click();
				
				Wait.waitForLoader();
			}
			
		catch(NullPointerException ex)
		{
			ex.getMessage();
		}
		
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}

	private void ApplyListPageFilter(String columnValue, String optionValue, String filterInput)
	{
		try {
		WebDriverWait wait = new WebDriverWait(Browser.webDriver, GlobalVariable.DelayVeryHigh);
		
		wait.until(ExpectedConditions.elementToBeClickable(changeObjectsXpath(linkFilter, "(//a[@data-test-selector='linkFilter'])[",  1)));
		
		linkFilter.click();
		
		wait.until(ExpectedConditions.visibilityOf(drpColumnList));
		
		SelectOption(drpColumnList, columnValue);
		
		SelectOption(drpOptionList, optionValue);
		
		txtFilterInput.sendKeys(filterInput);
		
		popBtnApplyFilter.click();
		
		Wait.waitForLoader();
		}
		
		catch(NullPointerException ex)
		{
			 ex.getMessage();
		}
		
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	
	
	private void SelectOption(WebElement webElement, String optionToBeSelected)
	{
		Select selectColumnValue = new Select(webElement);
		
		selectColumnValue.selectByVisibleText(optionToBeSelected);
	}
	
	private WebElement changeObjectsXpath(WebElement webElement, String xpath,int index)
	{
		webElement.findElement(By.xpath(xpath + index + "]"));
		
		return webElement;
	}
}
