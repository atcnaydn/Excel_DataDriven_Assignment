package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static ExcelReader excelRead = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");
	static String browser;
	static String url;

	public static WebDriver init() {

		browser = excelRead.getCellData("Sheet1", "Browser", 2);
		url = excelRead.getCellData("Sheet1", "URL", 2);

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		return driver;
	}

	public static void teardown() {

		driver.close();
		driver.quit();

	}

}
