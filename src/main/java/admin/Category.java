package admin;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonUtility.Filter;
import commonUtility.Wait;

public class Category {

	Filter filter = new Filter();
	
	@FindBy(xpath = "//*[@data-groupcode=\"Category\"]/a")
	private WebElement linkCategory;
	
	@FindBy(id = "divAssociateCategory")
	private WebElement btnAssociateCategory;
	
	@FindBy(xpath = "(//*[@name=\"PimCategoryId\"])[1]")
	private WebElement popUpFirstCheckBox;
	
	@FindBy(xpath = "(//*[@id=\"aside-popup-panel\"]//a)[1]")
	private WebElement btnPopUpSave;
	
	@FindBy(xpath = "//a[@class=\"z-edit\"]")
	private WebElement linkListPageEdit;
	
	public void associateCategory() 
	{
		try {
			if(linkListPageEdit.isDisplayed())
			{
				linkListPageEdit.click();
				
				Wait.waitForLoader();
			}
		}
		
		catch(ElementNotVisibleException ex)
		{
			ex.getMessage();
		}
		
		catch(Exception ex)
		{
			ex.getMessage();
		}
		
		finally
		{
			linkCategory.click();
			
			Wait.waitForLoader();
			
			btnAssociateCategory.click();
			
			Wait.waitForLoader();
			
			filter.typeOfFilter("PopUpPage", "Category", "Begins With", "CategoryAutomation");
			
			popUpFirstCheckBox.click();
			
			btnPopUpSave.click();
			
			Wait.waitForLoader();
		}
	}
}
