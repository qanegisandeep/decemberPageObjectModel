package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage{

	WebDriver driver ;
	ElementUtil elementUtil;
	
	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//li//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 15);
	}
	
	public void createNewContact(String mail, String fname, String lname, String jtitle) {
		elementUtil.waitForElementPresent(createContactButton, 15);
		elementUtil.doClick(createContactButton);
		
		elementUtil.waitForElementPresent(email, 15);
		elementUtil.doActionSendKeys(email, mail);
		
		elementUtil.waitForElementPresent(firstName, 10);
		elementUtil.doActionSendKeys(firstName, mail);
		
		elementUtil.waitForElementPresent(lastName, 10);
		elementUtil.doActionSendKeys(lastName, mail);
		
		elementUtil.waitForElementPresent(jobTitle, 10);
		elementUtil.doActionSendKeys(jobTitle, jtitle);
		
		elementUtil.waitForElementPresent(createContactFormButton, 10);
		elementUtil.doActionClick(createContactFormButton);
	}
	
}
