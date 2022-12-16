package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
//	webElement list
	@FindBy(how = How.XPATH,using = "//input[@id='username']")WebElement USERNAME_Element;
	@FindBy(how = How.XPATH,using = "//input[@id='password']")WebElement PASSWORD_Element;
	@FindBy(how = How.XPATH,using = "//button[@name='login']")WebElement SIGNIN_Element;

//	Corresponding method
	public  void insertUserName(String UserName) {
		
		USERNAME_Element.sendKeys(UserName);
	}
	public void insertPassword(String Password) {
		PASSWORD_Element.sendKeys(Password);
	}
	public void clickSignIn() {
		SIGNIN_Element.click();
	}

 
}