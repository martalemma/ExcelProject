package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	ExcelReader exlReader = new ExcelReader("TestData\\TestData.xlsx");
	String UserName = exlReader.getCellData("Login","UserName", 2);
	String Password = exlReader.getCellData("Login", "Password", 2);
    String DashboardValidation = exlReader.getCellData("Login", "DashBoardValidation", 2);
	String fullName = exlReader.getCellData("AddCustomer", "FullName", 2);
    String company = exlReader.getCellData("AddCustomer","CompanyName", 2);
    String email = exlReader.getCellData("AddCustomer", "Email", 2);
//    String phone = exlReader.getCellData("AddCustomer", "Phone", 2);
	String address = exlReader.getCellData("AddCustomer", "Address", 2);
	String city = exlReader.getCellData("AddCustomer", "City", 2);
	String state = exlReader.getCellData("AddCustomer", "State", 2);
//	String zip = exlReader.getCellData("AddCustomer", "Zip", 2);
	String country = exlReader.getCellData("AddCustomer", "Country", 2);
	String currency = exlReader.getCellData("AddCustomer", "Currency", 2);
	String group = exlReader.getCellData("AddCustomer", "Group", 2);
	
	
	WebDriver driver;
	@Test
	public void ValidUserShoulBeTbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(UserName);
		loginPage.insertPassword(Password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.ValidateDashboardPage(DashboardValidation);
		dashboardpage.clickCustomerMenu();
		dashboardpage.clickAddCustomerMenu();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
	addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropDown(company);
		addCustomerPage.inserEmai(email);
//		addCustomerPage.insertPhoneNum(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
//		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.selectCurrency(currency);
		addCustomerPage.selectGroup(group);
        addCustomerPage.clickSave();
        dashboardpage.clickListCustomerMenu();
        addCustomerPage.verifyInsertedNameAndDelete();

		
//		BrowserFactory.tearDown();
	}


}
