package com.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.constants.AppConstants;
import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1,enabled =false)
	public void getLoginPageTitle() {
		Assert.assertEquals(page.getPageInstance(LoginPage.class).getPageTitle(), AppConstants.HOME_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void lofinToWebsite() {
		HomePage homePage = page.getPageInstance(LoginPage.class).performLogin("03224444010", "4264158!", "9999");
		Assert.assertEquals(homePage.getHomePageHeading(),AppConstants.LOGGED_IN_PAGE_TITLE);
	}
		
		
}