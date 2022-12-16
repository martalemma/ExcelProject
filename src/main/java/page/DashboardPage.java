package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver= driver;
		
	}
//	WebElement
	@FindBy(how = How.XPATH,using = "//h2[text()=' Dashboard ']")
	WebElement DASHBOARD_Element;
	@FindBy(how = How.XPATH,using = "//span[text()='Customers']")
	WebElement CUSTEMER_Element;
	@FindBy(how = How.XPATH,using = "//a[text()='Add Customer']")
	WebElement ADDCUSTOMER_Element;
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'List Customers')]")
	WebElement LISTCUSTOMER_Element;
	
//  Corresponding method
	public void ValidateDashboardPage(String expectedResult) {
		Assert.assertEquals(DASHBOARD_Element.getText(),expectedResult,"Page not found");
	}
	
	public void clickCustomerMenu() {
		CUSTEMER_Element.click();
	}
	public void clickAddCustomerMenu() {
		ADDCUSTOMER_Element.click();
	}
	public void clickListCustomerMenu() throws InterruptedException {
		Thread.sleep(2000);
		LISTCUSTOMER_Element.click();
	}
}
