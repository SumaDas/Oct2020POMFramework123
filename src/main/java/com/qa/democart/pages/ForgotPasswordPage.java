package com.qa.democart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.democart.utils.ElementUtil;

public class ForgotPasswordPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private By emailId = By.id("input-email");
	private By continueBtn = By.cssSelector("/");
	private By emailAddressLabel = By.xpath("//legend[text()='Your E-Mail Address']");
	private By forgotPasswordHeader = By.xpath("//h1[text()='Forgot Your Password?']");

	/**
	 * Forgot Password page Constructor
	 * 
	 * @param driver
	 */
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	/**
	 * This method returns the header of Forgot Password page
	 * 
	 * @return string header value
	 */
	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(forgotPasswordHeader))
			return elementUtil.doGetText(forgotPasswordHeader);
		else
			return null;
	}

	/**
	 * This method returns the value of label-EmailAddress
	 * 
	 * @return EmailAddress label text
	 */
	public String getEmailAddressLabel() {
		if (elementUtil.doIsDisplayed(emailAddressLabel))
			return elementUtil.doGetText(emailAddressLabel);
		else
			return null;
	}

	/**
	 * This method enters mailId and clicks on continue button on Forgot Password
	 * page
	 * 
	 * @param mailId
	 * @return LoginPage object
	 */
	public LoginPage resetPassword(String mailId) {
		elementUtil.doSendKeys(emailId, mailId);
		elementUtil.doClick(continueBtn);
		return new LoginPage(driver);
	}
}
