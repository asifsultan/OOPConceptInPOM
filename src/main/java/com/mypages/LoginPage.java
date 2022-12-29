package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By welcomeDropdown = By.xpath("//a[contains(text(), ' Login')]");
	By loginLink = By.xpath("//a[contains(text(),'Login') and @href='/auth/reports/login']");
	By mobileNumber = By.xpath("//input[@formcontrolname='username']");
	By password = By.xpath("//input[@placeholder='Enter password']");
	By loginButton = By.xpath("//button[contains(text(), 'Login')]");
	By optInput = By.xpath("//input[@formcontrolname='otp']");
	By verifyButton = By.xpath("//button[contains(text(), 'Verify')]");
	By otpError = By.xpath("//div[@id='swal2-content']");
	By OkBtn = By.xpath("//button[contains(text(),'OK')]");
	By home = By.xpath("//p[text()='Home']");
	// By captcha = By.xpath("//div[@class='recaptcha-checkbox-checkmark']");

	public WebElement getWelcomeDropdown() {
		return getElement(welcomeDropdown);
	}

	public WebElement getLoginLink() {
		return getElement(loginLink);
	}

	public WebElement getMobileNumber() {
		return getElement(mobileNumber);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public WebElement getOtpText() {
		return getElement(optInput);
	}

	public WebElement getVerifyButton() {
		return getElement(verifyButton);
	}

	public WebElement getOtpError() {
		return getElement(otpError);
	}

	public WebElement getOkBtn() {
		return getElement(OkBtn);
	}

	public WebElement getHome() {
		return getElement(home);
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public HomePage performLogin(String username, String password, String otp) {
		getWelcomeDropdown().click();
		getLoginLink().click();
		getMobileNumber().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		if (driver.findElement(home).isDisplayed()) {
			return getPageInstance(HomePage.class);
		} else {
			enterOtp(otp);
			//return false;
			return getPageInstance(HomePage.class);
		}
		
		
		
	}
	
	public void performLogin(String userCred) {
		getWelcomeDropdown().click();
		getLoginLink().click();
		if( userCred.contains("username")) {
			getMobileNumber().sendKeys(userCred.split(":").clone()[1].trim());
		}else if( userCred.contains("password")) {
			getMobileNumber().sendKeys(userCred.split(":").clone()[1].trim());
		}
		getLoginButton().click();
		
		
	}

	public void enterOtp(String otp) {
		getOtpText().sendKeys(otp);
		getVerifyButton().click();
		getLoginButton().click();
//		if (driver.findElement(home).isDisplayed()) {
//			return true;
//		} else {
//			return false;
//		}
		
		
	}


///////////////////////////////////////////////||||||||||LOGIN||||||||\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//	public boolean loginToEPay(String username, String strPassword, String otp) throws InterruptedException {
//
//		performClick(welcomeDropdown);
//
//		performClick(loginLink);
//
//		sendText(mobileNumber, username);
//
//		sendText(password, strPassword);
//
//		performClick(loginButton);
//		if (driver.findElement(home).isDisplayed()) {
//			return true;
//		} else {
//			return false;
//		}
//
//		// Thread.sleep(200);
//		// driver.findElement(otpText).sendKeys(otp);
//
//		// driver.findElement(verifyButton).click();
//
//		// System.out.println("Login test passed");
//
//		//
//		// }catch(Exception e) {
//		//
//		// System.out.println("Login test failed");
//		// System.out.println(e.getMessage());
//		//
//		// }
//
//	}

}
