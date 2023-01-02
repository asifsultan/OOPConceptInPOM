package com.tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.constants.AppConstants;
import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1,enabled =false, groups = { "functest" })

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
	public void lofinToWebsite(String mobile,String password,String otp) {
		
		HomePage homePage = page.getPageInstance(LoginPage.class).performLogin(mobile, password, otp);
		Assert.assertEquals(homePage.getHomePageHeading(),AppConstants.LOGGED_IN_PAGE_TITLE);
	}
		
		
}
