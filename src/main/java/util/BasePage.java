package util;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	int randomNumber;

	public void selectFromDropdown(WebElement dropdownElement, String selection) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(selection);
	}

	public int randomNumberGenerator() {

		Random random = new Random();
		return randomNumber = random.nextInt(999);
	}

	public void waitForElement(WebDriver driver, WebElement element, int waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}