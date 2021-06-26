package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BasePage;

public class ListContactsPage {

	WebDriver driver;
	BasePage basePage = new BasePage();

	public ListContactsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ContactAssertion() {

		for (int i = 1; i <= 10; i++) {

			String tableXpath = "//table/tbody/tr[" + i + "]/td[3]";
			String actualName = driver.findElement(By.xpath(tableXpath)).getText();

			if (actualName.equalsIgnoreCase(AddContactPage.customName)) {

				System.out.println("Contact is on the list");
				break;

			} else if (i > 9) {
				throw new AssertionError("Contact not found");
			}
		}
	}

	public void deleteContact() {

		String customerNumber = null;

		for (int i = 1; i <= 10; i++) {

			String tableXpath = "//table/tbody/tr[" + i + "]/td[3]";
			String actualName = driver.findElement(By.xpath(tableXpath)).getText();

			if (actualName.equalsIgnoreCase(AddContactPage.customName)) {

				customerNumber = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText();
				System.out.println(customerNumber);

			}
		}

		String deleteButtonXpath = "//a[@href='delete/crm-user/" + customerNumber + "/']";
		driver.findElement(By.xpath(deleteButtonXpath)).click();

		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

	}

}
