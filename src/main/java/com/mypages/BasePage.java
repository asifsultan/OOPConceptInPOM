package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {

		return driver.getTitle();
	}

	@Override
	public String getPageUrl() {

		return driver.getCurrentUrl();
	}

	@Override
	public String getHeader(By locator) {
		
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element= driver.findElement(locator);
			return element;
		}catch(Exception e) {
			System.out.println("Some error has occured while creating element: " + locator.toString());
			e.printStackTrace();
		}
		return element;
	
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e ) {
			System.out.println("Some error/ exception occured while waiting for element: " + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e ) {
			System.out.println("Some error/ exception occured while waiting for title: " +title);
			e.printStackTrace();
		}
	}
		// wrapper methods..
		public void performClick(By locator) {
			getElement(locator).click();
		}
		public void sendText(By locator, String text) {
			getElement(locator).sendKeys(text);
		}
		public String fetchText(By locator) {
			return getElement(locator).getText();
		}
		
		public void selectFromIndex(By locator, int index) {
			Select item = new Select(getElement(locator));
			item.selectByIndex(index);
		}
		
		public void selectFromValues(By locator, String value) {
			Select item = new Select(getElement(locator));
			item.selectByValue(value);
		}
		public void selectUsingVisibleText(By locator, String text) {
			Select item = new Select(getElement(locator));
			item.selectByVisibleText(text);
		}

}
