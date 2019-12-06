package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By headerBannerSection = By.xpath("(//div[@class='private-header__inner'])[1]//h1[@class='private-page__title']");
	By profileIcon = By.xpath("//a[@id='account-menu']/img");
	
	By header = By.xpath("//h1[@class='private-header__heading']//h1");
	By accountName = By.xpath("//a[@id='account-menu']/span");
	By mainContactsLink = By.id("nav-primary-contacts-branch");
	By childContact = By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		return elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 15);
	}
	
	public boolean isHeaderPresent() {
		elementUtil.waitForElementPresent(headerBannerSection, 15);
		return elementUtil.isElementDisplayed(header);
	}
	
	public String getHomePageHeaderValue() {
		return elementUtil.doGetText(header);
	}
	
	public boolean isAccountNamePresent() {
		elementUtil.waitForElementPresent(profileIcon, 15);
		return elementUtil.isElementDisplayed(accountName);
	}
	
	public String getAccountNameValue() {
		return elementUtil.doGetText(accountName);
	}
	
	public void clickOnContacts() {
		elementUtil.waitForElementPresent(mainContactsLink, 15);
		elementUtil.doClick(mainContactsLink);
		elementUtil.waitForElementPresent(childContact, 5);
		elementUtil.doClick(childContact);
	}
	
	public ContactsPage goToContactspage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
}
