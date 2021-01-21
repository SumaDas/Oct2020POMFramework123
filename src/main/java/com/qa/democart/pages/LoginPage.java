package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private ElementUtil elementUtil;
	private WebDriver driver;
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By forgottenPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By warningMessage = By.xpath("//div[text()=' Warning: No match for E-Mail Address and/or Password.']");

	/**
	 * Login Page constructor
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	/**
	 * This method gets the login page title
	 * 
	 * @return login page title
	 */
	@Step("Getting login page title...")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.LOGIN_PAGE_TITLE, 5);
	}

	/**
	 * This method checks if all the forgotten password links exists on the page
	 * 
	 * @return true if all forgotten password links are displayed else return false
	 */
	@Step("checking Forgotten Password link is dispalyed on login page ...")
	public boolean isForgottenPwdLinkExist() {
		if (elementUtil.getElements(forgottenPwdLink).size() == Constants.FORGOTTEN_PWD_LINK_COUNT)
			return true;
		return false;
	}

	/**
	 * This method clicks on Forgotten Password link on login page
	 */
	@Step("Clicking on Forgotten Password link...")
	public ForgotPasswordPage clickOnForgottenPassword() {
		elementUtil.doClick(forgottenPwdLink);
		return new ForgotPasswordPage(driver);
	}

	/**
	 * This method does login with given positive credentials
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Step("logging with username : {0} and password : {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login with username : " + un + " and password : " + pwd);
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}
	
	/**
	 * This method does login with given negative credentials
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Step("login with wrong username : {0} and password : {1}")
	public boolean loginWithNegativeData(String un, String pwd) {
		System.out.println("Login with username : " + un + " and password : " + pwd);
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		String text = elementUtil.doGetText(warningMessage).trim();
		if(text.equals(Constants.LOGIN_PAGE_WARNING_MESSAGE.trim()))
			return true;
		return false;
		
	}
	@Step("navigating to Register Page...")
	public RegisterPage navigateToRegisterPage()
	{
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
}
