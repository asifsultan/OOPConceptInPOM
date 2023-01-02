package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;
	

	@BeforeMethod(groups = { "functest", "checkintest" })
	@Parameters(value = "browser")
	public void setup(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("No browser is defined in XML file");
		}
		
		driver.get("https://staging.epay.punjab.gov.pk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		page = new BasePage(driver);

	}

	@AfterMethod(groups = { "functest", "checkintest" })
	public void tearDown() {
		driver.quit();

	}

}
