package adminTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import admin.Products;
import commonUtility.Browser;
import commonUtility.Filter;
import commonUtility.GlobalVariable;

public class ProductsPage{

	Products products;
	Filter filter;
	
	@Test(priority=0)
	public void AddProduct()
	{
		products = PageFactory.initElements(Browser.webDriver,Products.class);
		products.AddNewProduct();
	}
	
	@Test(priority=1)
	public void FilterProduct()
	{
		filter = PageFactory.initElements(Browser.webDriver,Filter.class);
		filter.typeOfFilter("ListPage","SKU","Is",GlobalVariable.productName);
	}
}
