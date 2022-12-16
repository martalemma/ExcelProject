package page;

import java.awt.geom.GeneralPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver= driver;
		
	}
//	WebElement
	@FindBy(how = How.XPATH,using = "//input[@id='account']")
	WebElement FULLNAME_Element;
	@FindBy(how = How.XPATH,using = "//select[@id='cid']")
	WebElement COMPANY_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='email']")
	WebElement EMAIL_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='phone']")
	WebElement PPHONENUMBER_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='address']")
	WebElement ADDRESS_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='city']")
	WebElement CITY_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='state']")
	WebElement STATE_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='zip']")
	WebElement ZIP_Element;
	@FindBy(how = How.XPATH,using = "//select[@id='country']")
	WebElement COUNTRY_Element;
	@FindBy(how = How.XPATH,using = "//select[@id='currency']")
	WebElement CURRENCY_Element;
	@FindBy(how = How.XPATH,using = "//select[@id='group']")
	WebElement GROUP_Element;
	@FindBy(how = How.XPATH,using = "//button[@id='submit']")
	WebElement SAVE_Element;
	
	
// corresponding method
	 String insertName;
   public void insertFullName(String fullName) {
	   insertName = fullName + generatRandomNum(999);
	FULLNAME_Element.sendKeys(insertName);
	}
    public void selectCompanyDropDown(String company) {
    	selectDropDownMenu(COMPANY_Element, company);
    		
    }
    public void inserEmai(String email) {
    	String insertEmail = generatRandomNum(999)+ email;
    	EMAIL_Element.sendKeys(insertEmail);
    }
    public void insertPhoneNum(String phone) {
    	PPHONENUMBER_Element.sendKeys(phone + generatRandomNum(999));
    }
    public void insertAddress(String address) {
 	ADDRESS_Element.sendKeys(address);
 	}
    public void insertCity(String city) {
     	CITY_Element.sendKeys(city);
     	}
    public void insertState(String state) {
     	STATE_Element.sendKeys(state);
     	}
    public void insertZip(String zip) {
     	ZIP_Element.sendKeys(zip);
     	}
    public void selectCountry(String country) {
     	selectDropDownMenu(COUNTRY_Element, country);
     	}
    public void selectCurrency(String currency) {
     selectDropDownMenu(CURRENCY_Element, currency);
     	}
    public void selectGroup(String group) {
     	selectDropDownMenu(GROUP_Element, group);
     	}
    public void clickSave() {
     	SAVE_Element.click();
     	}
  //tbody/tr[1]/td[3]/a 
  //tbody/tr[2]/td[3]/a
  //tbody/tr[3]/td[3]/a
  //tbody/tr[i]/td[3]/
  //tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
  String beforex_path = "//tbody/tr[";
  String afterx_path = "]/td[3]";
  String afterx_path_delet = "]/td[3]/following-sibling::td[4]/a[2]";
  
  public void verifyInsertedNameAndDelete() throws InterruptedException {
//	  Thread.sleep(2000);
	  for(int i=1; i<=10; i++) {
	String enteredName = driver.findElement(By.xpath(beforex_path+i+afterx_path)).getText();
		  System.out.println(enteredName);
//		  Assert.assertEquals(enteredName, insertName, "Entered name doesn't match");
		  if(enteredName.contentEquals(insertName)) {
			  System.out.println("Entered name matched");
	driver.findElement(By.xpath(beforex_path+i+afterx_path_delet)).click();
			  
		  }
		  break;
	  }
	 
  }
  
}
