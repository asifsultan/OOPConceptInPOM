package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	


	By home = By.xpath("//p[text()='Home']");
	By excise = By.xpath("//a[@href='#3Submenu']");
	By tokenTax = By.xpath("//a[@href='/app/tokenTax']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getHome() {
		return getHeader(home);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	public String getHomePageHeading() {
		return getHome();
	}

	public GenerateTokenTaxPSID clickOnTokenTax() {
		
		getElement(excise).click();
		getElement(tokenTax).click();
		
		return getPageInstance(GenerateTokenTaxPSID.class);
		
		
	}

	

	

}
