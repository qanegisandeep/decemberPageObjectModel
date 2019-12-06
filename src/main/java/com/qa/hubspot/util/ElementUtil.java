package com.qa.hubspot.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	/**
	 * This is a constructor
	 * @param driver
	 */
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}

	/**
	 * Generic method for drop down using text
	 * @param element
	 * @param value
	 */
	public static void selectFromDropDownUsingText(WebElement element, String value) {
		Select dayList = new Select(element);
		dayList.selectByVisibleText(value);
	}
	/**
	 *  Generic method for drop down using Index
	 * @param element
	 * @param value
	 */
	public static void selectFromDropDownUsingIndex(WebElement element, int value) {
		Select dayList = new Select(element);
		dayList.selectByIndex(value);
	}
	
	/**
	 * This method is used to get and return all values from drop down
	 * @param element
	 * @return
	 */
	public static ArrayList<String> getValuesFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> dropList = select.getOptions();
		
		ArrayList<String> arr = new ArrayList<String>();
		
		for(int i=0; i< dropList.size(); i++) {
			String text = dropList.get(i).getText();
			arr.add(text);
		}
		return arr;
	}
	/**
	 *  This method is used to get values from drop down which do not have Select tag
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public static void getValuesFromDropDownWithoutSelect(WebDriver driver, String locator, String value) {
		
		List<WebElement> dropList = driver.findElements(By.xpath(locator));
		System.out.println(dropList.size());
		
		for(int i=0; i<dropList.size();i++) {
			String text = dropList.get(i).getText();
			if(text.equals(value)){
				dropList.get(i).click();
				break;
			}
			
		}
	}
	
	/**
	 * This method will return values available in options of Mouse right click
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static ArrayList<String> getAllOptionsUsingMouseRightClick(WebDriver driver, String locator) {
		List<WebElement> totalOptions = driver.findElements(By.xpath(locator));
		System.out.println("total = "+ totalOptions.size());
		
		ArrayList<String> values = new ArrayList<String>();
		
		for(int i=0; i<totalOptions.size(); i++) {
			String labelName = totalOptions.get(i).getText();
			values.add(labelName);
		}
		
		return values;
	}
	/**
	 * This method will return web element
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		
		WebElement element = null;
		try {
		      element = driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
		
	}
	
	/**
	 * This method will enter data in text field
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void doActionSendKeys(By locator, String value) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(getElement(locator), value).build().perform();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	/**
	 * This method will click on the web element
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void doActionClick(By locator) {
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void waitForElementPresent(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public String waitForTitlePresent(String title, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public String getPageTitle() {
		waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		
		try {
			String pageTitle = driver.getTitle();
			return pageTitle;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public String getPageHeader(By locator) {
		try {
			return getElement(locator).getText();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public boolean isElementDisplayed(By locator) {
		boolean flag = false;
		try {
			flag = getElement(locator).isDisplayed();
			return flag;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return flag;
		}
		
	}
	
	public void moveToOptionAndClick(By locator) {
		
		Actions action = new Actions(driver);
		try {
			action.moveToElement(getElement(locator)).click().build().perform();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
