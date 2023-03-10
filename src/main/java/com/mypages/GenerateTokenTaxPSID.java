package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenerateTokenTaxPSID extends BasePage {

	public GenerateTokenTaxPSID(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By carNumber = By.xpath("//input[@placeholder='Type Vehicle No here']");
	By searchButton = By.xpath("//button[contains(text(),'Search')]");
	By waitForSecondPane = By.xpath("//span[contains(text(), 'Vehicle Detail')]");
	By saveYes = By.xpath("//button[contains(text(),'Yes')]");
	By saveNo = By.xpath("//button[contains(text(),'No')]");
	By invalidRegBtn = By.xpath("//button[contains(text(),'OK')]");
	By saved = By.xpath("//button[contains(text(), 'OK')]");
	By generateChallan = By.xpath("//button[contains(text(), 'Generate Challan')]");
	By copyBtn = By.id("com.pitb.ePayGateway:id/copy");
	By home = By.xpath("//a[@href='/home']");
	By psid = By.xpath("//span[@class='margin-left']");
	By invalidPopup = By.id("swal2-content");
	By okayBtn = By.xpath("//button[contains(text(), 'OK')]");

	public WebElement getCarNumber() {
		return getElement(carNumber);
	}

	public WebElement getSearchButton() {
		return getElement(searchButton);
	}

	public WebElement getWaitForSecondPane() {
		return getElement(waitForSecondPane);
	}

	public WebElement getSaveYes() {
		return getElement(saveYes);
	}

	public WebElement getSaveNo() {
		return getElement(saveNo);
	}

	public WebElement getInvalidRegBtn() {
		return getElement(invalidRegBtn);
	}

	public WebElement getSaved() {
		return getElement(saved);
	}

	public WebElement getGenerateChallan() {
		return getElement(generateChallan);
	}

	public WebElement getCopyBtn() {
		return getElement(copyBtn);
	}

	public WebElement getHome() {
		return getElement(home);
	}

	public WebElement getPsid() {
		return getElement(psid);
	}

	public WebElement getInvalidPopup() {
		return getElement(invalidPopup);
	}

	public WebElement getOkayBtn() {
		return getElement(okayBtn);
	}

	public void generatePSID(String vehicleNo) {

		getCarNumber().sendKeys(vehicleNo);

		getSearchButton().click();
		try {
			getInvalidPopup().click();
		} catch (Exception e) {
		}

		
		driver.findElement(generateChallan).click();
		getPsid().getText();

		// driver.findElement(exciseAndTaxation).click();

	}

}
