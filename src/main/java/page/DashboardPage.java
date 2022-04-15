package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[2]/a/span") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement CUSTOMERS_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMERS_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement CUSTOMERS_LIST_ELEMENT;
	
	public void verifyDashboardPage () {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Dashbaord Page Not Found");
	}
	 
	public void clickCustomersMenuElement () {
		CUSTOMERS_MENU_ELEMENT.click();
	}
	
	public void clickAddCustomerElement () {
		ADD_CUSTOMERS_MENU_ELEMENT.click();
	}
	
	public void clickCustomersListElement () {
		CUSTOMERS_LIST_ELEMENT.click();
	}
	
}
