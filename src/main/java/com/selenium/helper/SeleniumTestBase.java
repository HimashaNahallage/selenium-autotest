package com.selenium.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestBase {
	/* The web driver */
	private WebDriver driver = null;

	/* The time out */
	private static int timeOut = 10;
	
	/* @param browser 
	  			the browser */ 
	public SeleniumTestBase(WebDriver driver) {
		this.driver = driver;
	}

	  /* Launch the given url
	   * @param url 
	   		    the url */
	public void open(String url) {
		driver.navigate().to(url);
	}

	 /* Find element in the web page 
	  * @param byLocator 
	  				the by locator */
	public WebElement findWebElement(By byLocator) {
		WebElement element = (new WebDriverWait(driver, timeOut))
				.until(ExpectedConditions.presenceOfElementLocated(byLocator));
		return element;
	}

	 /* Click on web element
	  * @param byLocator 
					the by locator */
	public void click(By byLocator) {
		WebElement element = findWebElement(byLocator);
		element.click();
	}
	
	 /* Type on web element
	  * @Param byLocator
	  * @param value */
	public void type(By byLocator, String value){
		WebElement element = findWebElement(byLocator);
		element.sendKeys(value);
	}
	
	public void scrolldown(By byLocator) throws AWTException{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	
	public void upload(By byLocator) throws AWTException{
		StringSelection selection = new StringSelection("C:\\Eclipse\\MavenToolsQA\\src\\main\\resources\\images");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null); //Copy the above string to clip board     
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL); //Paste the copied string into the dialog box
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER); //Enter    
	}
	
}
