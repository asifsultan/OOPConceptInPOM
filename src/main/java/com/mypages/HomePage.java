package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	


	By home = By.xpath("//p[text()='Home']");
	
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


	

	

}
