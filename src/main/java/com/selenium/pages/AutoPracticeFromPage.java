package com.selenium.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.helper.SeleniumTestBase;

public class AutoPracticeFromPage extends SeleniumTestBase {
	public AutoPracticeFromPage(WebDriver driver) {
		super(driver);
	}

	By byLocator = null;
	
	// private static By lnk_prtllink = By.partialLinkText("Partial Link Test");
	// private static By lnk_link = By.linkText("Link Test");
	private static By tf_frstname = By.xpath("//input[@name='firstname']");
	private static By tf_lstname = By.xpath("//input[@name='lastname']");
	private static By rbtn_sex = By.xpath("//input[@id='sex-0'][@value='Male']");
	private static By rbtn_exprience = By.cssSelector("input[id='exp-3']");
	// private static By tf_datepicker = By.xpath("//input[@id='datepicker']");
	private static By chkbx_profession = By.xpath("//input[@id='profession-1']");
	private static By btn_browse = By.xpath("//input[@name='photo']");
	private static By chkbx_autotool = By.xpath("//input[@id='tool-2']");
	private static By dd_continents = By.xpath("//select[@id='continents']/option[4]");
	private static By lstbx_selecmnds = By.xpath("//select[@id='selenium_commands']/option[5]");
	private static By btn_submit = By.xpath("//button[@id='submit']");

	public void enterDetailsToFrom(String firstname, String lastname) throws AWTException {
		type(tf_frstname, firstname);
		type(tf_lstname, lastname);
		click(rbtn_sex);
		click(rbtn_exprience);
		// type(tf_datepicker, date);
		click(chkbx_profession);
		scrolldown(byLocator);
		// upload
		click(btn_browse);
		upload(byLocator);
		click(chkbx_autotool);
		click(dd_continents);
		click(lstbx_selecmnds);
		click(btn_submit);
	}

}
