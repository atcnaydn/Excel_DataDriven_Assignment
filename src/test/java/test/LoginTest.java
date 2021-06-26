package test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.ListContactsPage;
import page.LoginPage;
import page.SummaryPage;
import util.BasePage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	BasePage basePage = new BasePage();
	
	
	ExcelReader excelRead = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");
	String username = excelRead.getCellData("Sheet1", "Username", 2);
	String password = excelRead.getCellData("Sheet1", "Password", 2);
	String accountName = excelRead.getCellData("Sheet1", "Account Name", 2);
	String company = excelRead.getCellData("Sheet1", "Company", 2);
	String email = excelRead.getCellData("Sheet1", "Email", 2);
	String phone = excelRead.getCellData("Sheet1", "Phone", 2);
	String address = excelRead.getCellData("Sheet1", "Address", 2);
	String city = excelRead.getCellData("Sheet1", "City", 2);
	String state = excelRead.getCellData("Sheet1", "State", 2);
	String zipCode = excelRead.getCellData("Sheet1", "Zip Code", 2);
	String country = excelRead.getCellData("Sheet1", "Country", 2);

	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.clickCustomers();
		dashboardPage.clickAddCustomers();
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		
		addContactPage.enterAccountName(accountName);
		addContactPage.selectCompany(company);
		addContactPage.enterEmail(email);
		addContactPage.enterPhone(phone);
		addContactPage.enterAddress(address);
		addContactPage.enterCity(city);
		addContactPage.enterState(state);
		addContactPage.enterZipCode(zipCode);
		addContactPage.selectCountry(country);
		addContactPage.clickSubmit();
		
		SummaryPage summaryPage = PageFactory.initElements(driver, SummaryPage.class);
		
		summaryPage.clickListCustomers();
		
		ListContactsPage listContactsPage = PageFactory.initElements(driver, ListContactsPage.class);
	
		listContactsPage.ContactAssertion();
		listContactsPage.deleteContact();
	
		BrowserFactory.teardown();
		
	}
	
	
}
