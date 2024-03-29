package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage = homePage.goToContactspage();
		
	}
	
	@Test
	public void verifyContactsPageTitleTest() {
		Assert.assertEquals(contactsPage.getContactsPageTitle(),Constants.CONTACTS_PAGE_TITLE);
	}
	
//	@DataProvider
//	public Object[][] getContactsTestData() {
//		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
//		return data;
//	}
	
	//@Test(dataProvider ="getContactsTestData")
//	public void createContactsTest(String email, String fname, String lname, String jobtitle) {
//		contactsPage.createNewContact(email, fname, lname, jobtitle);
//	}
	
//	@Test
//	public void createContactsTest() {
//		contactsPage.createNewContact("gf@gb.com", "adam","alex","warrior");
//	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
}
