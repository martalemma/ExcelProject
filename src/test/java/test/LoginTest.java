package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader exlReader = new ExcelReader("TestData\\TestData.xlsx");
	String UserName = exlReader.getCellData("Login","UserName", 2);
	String Password = exlReader.getCellData("Login", "Password", 2);
    String DashboardValidation = exlReader.getCellData("Login", "DashBoardValidation", 2);
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(UserName);
		loginPage.insertPassword(Password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardpage =PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.ValidateDashboardPage(DashboardValidation);
		BrowserFactory.tearDown();
		
	}

}
