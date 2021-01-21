package com.qa.opencart.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;

public class ForgotPasswordTest extends BaseTest {

	@BeforeClass
	public void forgotPasswordPageSetUp() {
		forgotPasswordPage = loginPage.clickOnForgottenPassword();
	}

	/**
	 * This test verifies the header value on Forgotten Password page
	 */
	@Test(priority = 1)
	public void getHeaderValueTest() {
		System.out.println("ForgotPassword page header value is : " + forgotPasswordPage.getHeaderValue());
		Assert.assertEquals(Constants.FORGOTPASSWORD_PAGE_HEADER, forgotPasswordPage.getHeaderValue());
	}

	/**
	 * This test verifies EmailAddress label on ForgottenPassword page
	 */
	@Test(priority = 2)
	public void verifyEmailAddressLabelTest() {
		System.out.println(
				"ForgotPassword page EmailAddress label value is : " + forgotPasswordPage.getEmailAddressLabel());
		Assert.assertEquals(Constants.FORGOTPASSWORD_PAGE_EMAILADDRESS_LABEL,
				forgotPasswordPage.getEmailAddressLabel());
	}

	/**
	 * This test enters the email and clicks on continue button, landing on
	 * LoginPage
	 */
	@Test(priority = 3)
	public void resetPasswordTest() {
		forgotPasswordPage.resetPassword(prop.getProperty("username"));

	}

}
