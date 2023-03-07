package com.upgrade.codingchallenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
	private By header = By.xpath("//*[@id='___gatsby']//header");
	private By content = By.xpath("//*[@id='___gatsby']//main");
	private By footer = By.xpath("//*[@id='___gatsby']//footer");
	protected WebDriver driver;

	public WebElement getHeader() {		
		return driver.findElement(header);
	}

	public WebElement getContent() {
		return driver.findElement(content);
	}

	public WebElement getFooter() {
		return driver.findElement(footer);
	}
	
}
