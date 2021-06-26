package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMERS_FIELD;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement ADD_CUSTOMER_FIELD;
	
	//Interactive Methods
	
	public void clickCustomers() {
		CUSTOMERS_FIELD.click();
	}
	
	public void clickAddCustomers() {
		ADD_CUSTOMER_FIELD.click();
	}
	

}
