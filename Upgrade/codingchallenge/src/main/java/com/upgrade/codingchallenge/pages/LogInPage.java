package com.upgrade.codingchallenge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.upgrade.codingchallenge.utils.Driver;

public class LogInPage {
	@FindBy(how = How.ID_OR_NAME, using = "username")
	@CacheLookup
	private WebElement username;

	@FindBy(how = How.ID_OR_NAME, using = "password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	@CacheLookup
	private WebElement btnSubmit;
		
	public WebElement getUsername() {
		return username;
	}

	public void setUsername(String _username) {
		username.clear();
		username.sendKeys(_username);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		password.clear();
		password.sendKeys(_password);
	}

	public OfferPage clickSubmitButton() {
		Actions actions = new Actions(Driver.getWebDriverInstance());
		actions.moveToElement(btnSubmit).click().build().perform();		
		return PageFactory.initElements(Driver.getWebDriverInstance(), OfferPage.class);
	}
}
