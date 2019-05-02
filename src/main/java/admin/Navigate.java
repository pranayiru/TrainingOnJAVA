package admin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.Browser;

public class Navigate {
	@FindBy(xpath = "//a[@data-test-selector='linkNavMenu']")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@data-test-selector='linkProducts']")
	private WebElement linkProducts;
	
	@FindBy(xpath = "//div[@id=\'loading-div-background\']")
	private WebElement loader;
	

	public void NavigateToProduct()
	{	
		//loadingWait(Browser.webDriver, loader);
		loadingWait(12);
		menu.click();
		loadingWait(5);
		linkProducts.click();
		loadingWait(5);
		//loadingWait(Browser.webDriver, loader);
	}
	
	public void loadingWait(int wait) {
//		WebDriver driver, WebElement element
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to appear
//	    wait.until(ExpectedConditions.invisibilityOf(element)); // wait for loader to disappear
	    
	    Browser.webDriver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	public static final ExpectedCondition<Boolean> EXPECT_NO_SPINNERS = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver driver) {
	        Boolean loaded = true;
	        try {
	        List<WebElement> spinners = driver.findElements(By.className("spinner"));
	        for (WebElement spinner : spinners) {
	            if (spinner.isDisplayed()) {
	                loaded = false;
	                break;
	            }
	        }
	        }catch (Exception ex) {
	            loaded = false;
	        }
	        return loaded;
	    }
	};

}
