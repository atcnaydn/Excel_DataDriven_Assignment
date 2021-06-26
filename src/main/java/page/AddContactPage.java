package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.BasePage;

public class AddContactPage {

	WebDriver driver;

	BasePage basePage = new BasePage();

	static String customName;
	
	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement ACCOUNT_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_CODE_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SUBMIT_BUTTON;

	// Interactable Methods

	public void enterAccountName(String accountName) {
		basePage.waitForElement(driver, ACCOUNT_NAME_FIELD, 10);
		int randomNumber = basePage.randomNumberGenerator();
		customName = accountName + randomNumber;
		ACCOUNT_NAME_FIELD.sendKeys(customName);
	}

	public void selectCompany(String company) {
		basePage.selectFromDropdown(COMPANY_DROPDOWN, company);
	}

	public void enterEmail(String email) {
		int randomNumber = basePage.randomNumberGenerator();
		EMAIL_FIELD.sendKeys(randomNumber + email);
	}

	public void enterPhone(String phone) {
		int randomNumber = basePage.randomNumberGenerator();
		PHONE_FIELD.sendKeys(randomNumber + phone);
	}

	public void enterAddress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}

	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}

	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}
	
	public void enterZipCode(String zipCode) {
		ZIP_CODE_FIELD.sendKeys(zipCode);
	}

	public void selectCountry(String country) {
		basePage.selectFromDropdown(COUNTRY_DROPDOWN, country);

	}

	public void clickSubmit() {
		SUBMIT_BUTTON.click();
	}
	

}