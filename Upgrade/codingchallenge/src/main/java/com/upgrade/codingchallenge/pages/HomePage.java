package com.upgrade.codingchallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.upgrade.codingchallenge.utils.Driver;

public class HomePage extends Page {
	
	@FindBy(how = How.ID, using = "loan-amount")
	@CacheLookup
	private WebElement loanAmount;

	@FindBy(how = How.ID, using = "loan-purpose-select")
	@CacheLookup
	private WebElement loanPurpose;
	
	@FindBy(how = How.ID, using = "loan-form-submit")
	@CacheLookup
	private WebElement submitButton;	
	
	protected WebDriver driver;

	public String getLoanAmount() {
		return loanAmount.getAttribute("value");
	}

	public void setLoanAmount(String amount) {
		loanAmount.clear();
		loanAmount.sendKeys(amount);
	}

	public WebElement getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String purpose) {
		Select purposes = new Select(loanPurpose);
		purposes.selectByValue(purpose);
	}

	public BasicInfoPage clickSubmitButton() {
		submitButton.click();
		driver =  Driver.getWebDriverInstance();
		return PageFactory.initElements(driver, BasicInfoPage.class);
	}	
}
