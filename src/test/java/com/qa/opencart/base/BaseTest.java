package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.democart.factory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.ForgotPasswordPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.RegisterPage;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;
	public ForgotPasswordPage forgotPasswordPage;
	public AccountsPage accountPage;
	public RegisterPage registerPage;

	/**
	 * This method will initialize the driver and start browser
	 */
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		driver.get(prop.getProperty("url"));	
		loginPage = new LoginPage(driver);
	}

	/**
	 * This method will quit the browser
	 */
	public void tearDown() {
		driver.quit();
	}
}
