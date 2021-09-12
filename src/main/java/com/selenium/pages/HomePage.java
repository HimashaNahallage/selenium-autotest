package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.helper.SeleniumTestBase;

public class HomePage extends SeleniumTestBase {
	// An explicit constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	private static By nav_bar = By.linkText("DEMO SITES");
	private static By dd_navbar = By.linkText("Automation Practice Form");

	public void loginToSite(WebDriver driver) {
		open("http://toolsqa.com/");
		click(nav_bar);
		click(dd_navbar);
	}
}
