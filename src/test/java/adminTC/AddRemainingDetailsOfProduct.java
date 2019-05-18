package adminTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import admin.EditProduct;
import admin.Products;
import commonUtility.Browser;

public class AddRemainingDetailsOfProduct {

	EditProduct editProduct;

	@Test(priority=0)  				// Test case to open the browser and pass the url
	public void ClickEdit()
	{	
		editProduct = PageFactory.initElements(Browser.webDriver,EditProduct.class);
		editProduct.ClickOnEditLink();
	}
	
	@Test(priority=1)  				// Test case to open the browser and pass the url
	public void EditProduct()
	{	
		editProduct.AddProductDetails();
	}
}
