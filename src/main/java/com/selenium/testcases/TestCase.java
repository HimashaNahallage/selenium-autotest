package com.selenium.testcases;

import java.awt.AWTException;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.selenium.pages.AutoPracticeFromPage;
import com.selenium.pages.HomePage;

public class TestCase {
	
	WebDriver driver;
	HomePage homepage;

	@Parameters({"browser"})
	@BeforeTest
	public void crossBrowserTest(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			File file = new File("src/main/resources/drivers" + File.separator + "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			driver = new FirefoxDriver();
			
		} else if (browser.equalsIgnoreCase("chrome")) {
			File file = new File("src/main/resources/drivers" + File.separator + "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("ie")) {
			File file = new File("src/main/resources/drivers" + File.separator + "iexplore.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@Test(dataProvider = "fillData")
	public void selectTheForm(String firstname, String lastname) throws AWTException {
		HomePage homepage = new HomePage(driver);
		homepage.loginToSite(driver);
		AutoPracticeFromPage auto = new AutoPracticeFromPage(driver);
		auto.enterDetailsToFrom(firstname, lastname);
	}

	@DataProvider
	public Object[][] fillData() {
		return new Object[][] { new Object[] { "Anne", "Thomas" }, };
	}

	@AfterTest
	public void closeBrowser() {
		  driver.close();
		  driver.quit();
	}
}
