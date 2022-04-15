package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	
	
	//@Test
	@Parameters({"UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToCreateCustomer (String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSignInButton(); 
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersMenuElement();
		dashboardPage.clickAddCustomerElement();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage .verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryFromDropDown(country);
		addCustomerPage.clickSaveButton();
		addCustomerPage.verifyProfilePage();
		dashboardPage.clickCustomersListElement();
		addCustomerPage.verifyEnteredNameAndDelete();
		
	}
	@Test
	@Parameters({"UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToCreateCustomerFromListCustomer (String userName, String password, String fullName, String companyName, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSignInButton(); 
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersMenuElement();
		dashboardPage.clickCustomersListElement();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomer();
		addCustomerPage .verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryFromDropDown(country);
		addCustomerPage.clickSaveButton();
		addCustomerPage.verifyProfilePage();
		
		dashboardPage.clickCustomersListElement();
		
		
		addCustomerPage.insertSearchBarOnListCustomer();
		addCustomerPage.verifyEnteredNameOnSearchAndProfile();
		
	}
}
