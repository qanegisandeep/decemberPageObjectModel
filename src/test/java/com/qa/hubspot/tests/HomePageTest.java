package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(),Constants.HOME_PAGE_TITLE);
	}

	@Test
	public void verifyHomePageHeaderTest() {
		Assert.assertTrue(homePage.isHeaderPresent());
		Assert.assertEquals(homePage.getHomePageHeaderValue(),Constants.HOME_PAGE_HEADER);
	}
	
	@Test
	public void verifyLoggedInUserTest() {
		Assert.assertTrue(homePage.isAccountNamePresent());
		Assert.assertEquals(homePage.getAccountNameValue(), prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
