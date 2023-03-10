package com.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.constants.AppConstants;
import com.mypages.GenerateTokenTaxPSID;
import com.mypages.HomePage;
import com.mypages.LoginPage;

public class GenerateTokenPsidTest extends BaseTest{

	@Test(priority = 1,enabled =true, groups = { "functest" })

	public void getLoginPageTitle() {
		Assert.assertEquals(page.getPageInstance(LoginPage.class).getPageTitle(), AppConstants.HOME_PAGE_TITLE);
	}
	@DataProvider (name = "credentials")
	public Object [][] UserCredentials(){
		return new Object [][] {
			{"03224444010","4264158!","9999"}
			};
	}
	@Test(priority = 2,groups = { "functest", "checkintest" }, dataProvider = "credentials")
	public void loginToWebsite(String mobile,String password,String otp) {
		LoginPage lpage = new LoginPage(driver);
		HomePage homePage = lpage.performLogin(mobile, password, otp);
		Assert.assertEquals(homePage.getHomePageHeading(),AppConstants.LOGGED_IN_PAGE_TITLE);
	}
	@Test(priority = 3,groups = { "functest", "checkintest" })
	public void getHomePageTitle() {
		//LoginPage lpage = new LoginPage(driver);
		page.getPageInstance(HomePage.class).getHome();
		//Assert.assertEquals(homePage.getHomePageHeading(),AppConstants.LOGGED_IN_PAGE_TITLE);
	}
	@Test(priority = 4,groups = { "functest", "checkintest" })
	public void clickOnExciseAndTokenTax() {
		//LoginPage lpage = new LoginPage(driver);
		page.getPageInstance(HomePage.class).clickOnTokenTax();
		//Assert.assertEquals(homePage.getHomePageHeading(),AppConstants.LOGGED_IN_PAGE_TITLE);
	}
	@DataProvider (name = "vehicleNumber")
	public Object [][] VehicleSearch(){
		return new Object [][] {
			{"IDS 943"}
			};
	}
	@Test(priority = 5,groups = { "functest", "checkintest" }, dataProvider = "vehicleNumber")
	public void generatePSID(String vehNo) {
		//LoginPage lpage = new LoginPage(driver);
		page.getPageInstance(GenerateTokenTaxPSID.class).generatePSID(vehNo);
		//Assert.assertEquals(homePage.getHomePageHeading(),AppConstants.LOGGED_IN_PAGE_TITLE);
	}
}
