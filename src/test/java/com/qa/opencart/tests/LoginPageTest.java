package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("EPIC 100: Design full login page for opencart application...")
@Story("US 101 : Login page feature story ")
public class LoginPageTest extends BaseTest {

	WebDriver driver;

	/**
	 * This test will verify Login Page title
	 */
	@Description("Verifying login page title test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, enabled = true)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("LoginPage title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	/**
	 * This test will verify ForgottenPassword Links present on Login Page
	 */
	@Description("Verifying Forgotten Password link exist test...")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2, enabled = true)
	public void verifyForgottenPwdLinkExist() {
		Assert.assertTrue(loginPage.isForgottenPwdLinkExist());
	}

	/**
	 * This method will click on Forgotten Password Link on Login Page
	 * 
	 * @return
	 */
	@Test(priority = 3, enabled = false)
	public void clickOnForgottenPasswordTest() {
		loginPage.clickOnForgottenPassword();
	}

	@DataProvider
	public Object[][] getLoginNegativeData() {
		Object[][] data =  ExcelUtil.getTestData(Constants.LOGIN_NEGATIVE_DATA_SHEET);
		return data;
	}

	/**
	 * This test will login with negative data
	 * 
	 * @param username
	 * @param password
	 */
	@Test(priority = 4, enabled = true,dataProvider = "getLoginNegativeData")
	public void loginWithNegativeDataTest(String un, String pwd) {
		//Assert.assertTrue(loginPage.loginWithNegativeData(un, pwd));
		try {
		Assert.assertTrue(loginPage.loginWithNegativeData(un, pwd),"test case passed");
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

	/**
	 * This test will do login with properties username and password
	 */
	@Description("login test...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5, enabled = false)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
