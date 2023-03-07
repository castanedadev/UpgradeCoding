package com.upgrade.codingchallenge.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.upgrade.codingchallenge.utils.Driver;

public class BasicInfoPage {
	@FindBy(how = How.NAME, using = "borrowerFirstName")
	@CacheLookup
	private WebElement borrowerFirstName;

	@FindBy(how = How.NAME, using = "borrowerLastName")
	@CacheLookup
	private WebElement borrowerLastName;

	@FindBy(how = How.NAME, using = "borrowerStreet")
	@CacheLookup
	private WebElement borrowerStreet;

	@FindBy(how = How.NAME, using = "borrowerCity")
	@CacheLookup
	private WebElement borrowerCity;

	@FindBy(how = How.NAME, using = "borrowerState")
	@CacheLookup
	private WebElement borrowerState;

	@FindBy(how = How.NAME, using = "borrowerZipCode")
	@CacheLookup
	private WebElement borrowerZipCode;

	@FindBy(how = How.NAME, using = "borrowerDateOfBirth")
	@CacheLookup
	private WebElement borrowerDateOfBirth;

	@FindBy(how = How.NAME, using = "borrowerIncome")
	@CacheLookup
	private WebElement borrowerIncome;

	@FindBy(how = How.NAME, using = "borrowerAdditionalIncome")
	@CacheLookup
	private WebElement borrowerAdditionalIncome;

	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	private WebElement username;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(how = How.NAME, using = "agreements")
	@CacheLookup
	private WebElement cbTermsOfUse;

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	@CacheLookup
	private WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']//main//header/div/label")
	@CacheLookup
	private WebElement topRightCornerMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/header/div")
	@CacheLookup
	private WebElement signOutBtn;

	public WebElement getBorrowerFirstName() {
		return borrowerFirstName;
	}

	public void setBorrowerFirstName(String bFirstName) {
		borrowerFirstName.clear();
		borrowerFirstName.sendKeys(bFirstName);
	}

	public WebElement getBorrowerLastName() {
		return borrowerLastName;
	}

	public void setBorrowerLastName(String bLastName) {
		borrowerLastName.clear();
		borrowerLastName.sendKeys(bLastName);
	}

	public WebElement getBorrowerStreet() {
		return borrowerStreet;
	}

	public void setBorrowerStreet(String bStreet) {
		try {
			borrowerStreet.clear();
			borrowerStreet.sendKeys(bStreet);
			Thread.sleep(1000);
			borrowerStreet.sendKeys(Keys.TAB);
		} catch (Exception ex) {
			System.out.println("Failed while setting borrower street");
		}
	}

	public WebElement getBorrowerCity() {
		return borrowerCity;
	}

	public void setBorrowerCity(String bCity) {
		borrowerCity.clear();
		borrowerCity.sendKeys(bCity);
	}

	public WebElement getBorrowerState() {
		return borrowerState;
	}

	public void setBorrowerState(String bState) {
		borrowerState.clear();
		borrowerState.sendKeys(bState);
	}

	public WebElement getBorrowerZipCode() {
		return borrowerZipCode;
	}

	public void setBorrowerZipCode(int bZipCode) {
		borrowerZipCode.clear();
		borrowerZipCode.sendKeys(String.valueOf(bZipCode));
	}

	public WebElement getBorrowerDateOfBirth() {
		return borrowerDateOfBirth;
	}

	public void setBorrowerDateOfBirth(String bDateOfBirth) {
		try {
			borrowerDateOfBirth.clear();
			// WebDriver driver = Driver.getWebDriverInstance();
			// JavascriptExecutor executor = (JavascriptExecutor)driver;
			// executor.executeScript("document.getElementsByName('borrowerDateOfBirth')[0].setAttribute('value',
			// '"+ bDateOfBirth+"')");
			borrowerDateOfBirth.sendKeys(bDateOfBirth);
		} catch (Exception ex) {
			System.out.println("Failed while entering DOB!");
		}
	}

	public WebElement getBorrowerIncome() {
		return borrowerIncome;
	}

	public void setBorrowerIncome(String bIncome) {
		borrowerIncome.clear();
		borrowerIncome.sendKeys(bIncome);
	}

	public WebElement getBorrowerAdditionalIncome() {
		return borrowerAdditionalIncome;
	}

	public void setBorrowerAdditionalIncome(String bAdditionalIncome) {
		borrowerAdditionalIncome.clear();
		borrowerAdditionalIncome.sendKeys(bAdditionalIncome);
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(String bUsername) {
		username.clear();
		username.sendKeys(bUsername);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String bPassword) {
		password.clear();
		password.sendKeys(bPassword);
	}

	public void selectTermsOfUse() {
		WebDriver driver = Driver.getWebDriverInstance();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", cbTermsOfUse);
	}

	public OfferPage clickSubmitButton() {
		Actions actions = new Actions(Driver.getWebDriverInstance());
		actions.moveToElement(btnSubmit).click().build().perform();		
		return PageFactory.initElements(Driver.getWebDriverInstance(), OfferPage.class);
	}

	public void getTopRightCornerMenu() {
		Actions actions = new Actions(Driver.getWebDriverInstance());
		actions.moveToElement(topRightCornerMenu).click().build().perform();
	}

	public void setTopRightCornerMenu(WebElement topRightCornerMenu) {
		this.topRightCornerMenu = topRightCornerMenu;
	}

	public void clickSignOutBtn() {
		Actions actions = new Actions(Driver.getWebDriverInstance());
		actions.moveToElement(signOutBtn).click().build().perform();	
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
}
