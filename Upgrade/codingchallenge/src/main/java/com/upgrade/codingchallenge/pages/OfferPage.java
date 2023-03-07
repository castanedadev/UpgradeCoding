package com.upgrade.codingchallenge.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.upgrade.codingchallenge.utils.Driver;

public class OfferPage {
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span[2] ")
	@CacheLookup
	private WebElement loanAmount;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[3]/div/div")
	@CacheLookup
	private WebElement aprValue;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]")
	@CacheLookup
	private WebElement loanTerm;	
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div/span")
	@CacheLookup
	private WebElement monthlyPayment;
	
	@FindBy(how = How.CLASS_NAME, using = "header-nav")
	@CacheLookup
	private WebElement topRightCornerMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/main/div/header/div")
	@CacheLookup
	private WebElement signOutBtn;

	public WebElement getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(WebElement loanAmount) {
		this.loanAmount = loanAmount;
	}

	public WebElement getAprValue() {
		return aprValue;
	}

	public void setAprValue(WebElement aprValue) {
		this.aprValue = aprValue;
	}

	public WebElement getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(WebElement loanTerm) {
		this.loanTerm = loanTerm;
	}

	public WebElement getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(WebElement monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public WebElement getTopRightCornerMenu() {
		return topRightCornerMenu;
	}
	public void clickTopRightCornerMenu() {
//		Actions actions = new Actions(Driver.getWebDriverInstance());
//		actions.moveToElement(topRightCornerMenu).click().build().perform();
		JavascriptExecutor executor = (JavascriptExecutor) Driver.getWebDriverInstance();
		executor.executeScript("arguments[0].click();", topRightCornerMenu);
	}

	public void setTopRightCornerMenu(WebElement topRightCornerMenu) {
		this.topRightCornerMenu = topRightCornerMenu;
	}

	public LogInPage clickSignOutBtn() {
		Actions actions = new Actions(Driver.getWebDriverInstance());
		actions.moveToElement(signOutBtn).click().build().perform();	
		
		return PageFactory.initElements(Driver.getWebDriverInstance(), LogInPage.class);
	}

	public WebElement gettSignOutBtn() {
		return signOutBtn;
	}
	
}
