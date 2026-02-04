package com.united.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
	protected Logger log; 
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.log = LogManager.getLogger(this.getClass());
	}
	
	public void isDisplayed(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void selectByVisibleText(String text, WebElement ele) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	

}
