package com.upgrade.codingchallenge;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.upgrade.codingchallenge.pages.BasicInfoPage;
import com.upgrade.codingchallenge.pages.HomePage;
import com.upgrade.codingchallenge.pages.LogInPage;
import com.upgrade.codingchallenge.pages.OfferPage;
import com.upgrade.codingchallenge.utils.Driver;
import com.upgrade.codingchallenge.utils.Utils;

public class TestLoanDetailsUI {
	private WebDriver driver;
	private String baseUrl = "https://www.credify.tech/";
	private WebDriverWait wait;

	private static final Logger LOGGER = Logger.getLogger(TestLoanDetailsUI.class.getName());

	@BeforeMethod
	public void setUp() {
		driver = Driver.getWebDriverInstance();
		wait = new WebDriverWait(driver, 30);
	}

	@Test(enabled = true)
	public void loanOffersUITest() {
		LOGGER.log(Level.INFO, "About to start loanOffersUITest()");
		String email, password, loanAmount, monthlyPayment, loanTerm, apr;
		
		driver.navigate().to(baseUrl);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		wait.until(ExpectedConditions.visibilityOf(home.getLoanPurpose()));

		home.setLoanAmount("2000");
		home.setLoanPurpose("CREDIT_CARD");
		BasicInfoPage basicInfoPage = home.clickSubmitButton();
		wait.until(ExpectedConditions.visibilityOf(basicInfoPage.getBorrowerFirstName()));

		basicInfoPage.setBorrowerFirstName(Utils.generateRandomString());
		basicInfoPage.setBorrowerLastName(Utils.generateRandomString());
		wait.until(ExpectedConditions.visibilityOf(basicInfoPage.getBorrowerStreet()));
		basicInfoPage.setBorrowerStreet(Utils.US_STREET);
		basicInfoPage.setBorrowerCity(Utils.US_CITY);
		basicInfoPage.setBorrowerState(Utils.US_STATE);
		basicInfoPage.setBorrowerZipCode(Utils.US_ZIP_CODE);
		basicInfoPage.setBorrowerDateOfBirth(Utils.generateValidDOB(1930, 2000));
		basicInfoPage.setBorrowerIncome("100,000");
		basicInfoPage.setBorrowerAdditionalIncome("5,000");

		email = Utils.generateEmail();
		password = Utils.generatePassword();
		basicInfoPage.setUsername(email);
		basicInfoPage.setPassword(password);
		basicInfoPage.selectTermsOfUse();
		OfferPage offerPage = basicInfoPage.clickSubmitButton();
		wait.until(ExpectedConditions.visibilityOf(offerPage.getLoanAmount()));

		loanAmount = offerPage.getLoanAmount().getText().trim();
		monthlyPayment = offerPage.getMonthlyPayment().getText().trim();
		loanTerm = offerPage.getLoanTerm().getText().trim();
		apr = offerPage.getAprValue().getText().split("\\(")[0].trim();

		wait.until(ExpectedConditions.visibilityOf(offerPage.getTopRightCornerMenu()));
		offerPage.clickTopRightCornerMenu();
		wait.until(ExpectedConditions.visibilityOf(basicInfoPage.getSignOutBtn()));
		LogInPage logInPage = offerPage.clickSignOutBtn();

		driver.navigate().to(baseUrl + "portal/login");
		wait.until(ExpectedConditions.visibilityOf(logInPage.getUsername()));
		logInPage.setUsername(email);
		logInPage.setPassword(password);
		offerPage = logInPage.clickSubmitButton();
		wait.until(ExpectedConditions.visibilityOf(offerPage.getLoanAmount()));

		// Validation points
		AssertJUnit.assertEquals("Loan Amount matches preiously stored value.", loanAmount, offerPage.getLoanAmount().getText().trim());
		AssertJUnit.assertEquals("Monthly Payment matches preiously stored value.", monthlyPayment, offerPage.getMonthlyPayment().getText().trim());
		AssertJUnit.assertEquals("Loan Term matches preiously stored value.", loanTerm, offerPage.getLoanTerm().getText().trim());
		AssertJUnit.assertEquals("APR matches preiously stored value.", apr, offerPage.getAprValue().getText().split("\\(")[0].trim());
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.closeWebBrowser();
	}

}
