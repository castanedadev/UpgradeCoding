package com.upgrade.codingchallenge.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {
	private static WebDriver driver;

	private Driver() {
	}

	public static WebDriver getWebDriverInstance() {
		// System.setProperty("webdriver.chrome.driver","src\\driver\\binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
		// driver = new ChromeDriver();
		// System.setProperty("webdriver.edge.driver","src\\driver\\binaries\\windows\\edge\\64bit\\MicrosoftWebDriver.exe");
		// driver = new EdgeDriver();
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver",
					"src\\driver\\binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
			driver = new ChromeDriver();
//			 System.setProperty("webdriver.edge.driver","src\\driver\\binaries\\windows\\edge\\64bit\\MicrosoftWebDriver.exe");
//			 driver = new EdgeDriver();
		}
		return driver;
	}

	public static void closeWebBrowser() {
		if (null != driver) {
			driver.quit();
		}
		driver = null;
	}
}
