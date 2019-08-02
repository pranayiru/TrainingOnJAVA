package adminTC;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import SEO.AddSEODetails;
import commonUtility.Browser;

public class SEO {
	AddSEODetails addDetails;

	@Test(priority=0)  				// Test case to open the browser and pass the url
	public void ClickEdit()
	{	
		addDetails = PageFactory.initElements(Browser.webDriver, AddSEODetails.class);
		addDetails.setSEODetails();
	}
}
