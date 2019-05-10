package adminTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import admin.Products;
import commonUtility.Browser;

public class ProductsPage {

	Products products;
	
	@Test(priority=0)
	public void AddProduct()
	{
		products = PageFactory.initElements(Browser.webDriver,Products.class);
		products.AddNewProduct();
	}
}
