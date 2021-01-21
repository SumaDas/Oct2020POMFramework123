package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {

	
	@BeforeClass
	public void regPageSetUp()
	{
		registerPage = loginPage.navigateToRegisterPage();
	}
	@DataProvider
	public Object[][] getRegData()
	{
		Object[][] data = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	@Test(dataProvider = "getRegData")
	public void userRegistrationTest(String firstName, String lastName,String emailID, String phone,String pwd,String subscribe)
	{
		registerPage.accountRegistration( firstName, lastName, emailID, phone, pwd, subscribe);
	}
}
