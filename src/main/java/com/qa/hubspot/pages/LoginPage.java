package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	By emailid = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUplink = By.linkText("Sign up");
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 15);
	}
	
	public String getPageTitle() {
		String title = elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 15);
		System.out.println("title = : "+title);
		return title;
	}
	
	public boolean verifySignUpLink() {
		return elementUtil.isElementDisplayed(signUplink);
	}
	
	public HomePage doLogin(String username, String pwd) {
		elementUtil.doSendKeys(emailid, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 15);
		return new HomePage(driver);
	}
}
