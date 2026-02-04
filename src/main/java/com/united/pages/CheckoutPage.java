package com.united.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.united.base.BasePage;

public class CheckoutPage extends BasePage {
	
	@FindBy(xpath = "//div/select")
	private WebElement dropDown;
	
	@FindBy(css = ".chkAgree")
	private WebElement checkBox;
	
	@FindBy(xpath = "//button[text() = 'Proceed']")
	private WebElement proceedToCheckOut;
	

	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectCountry(String country) {
		selectByVisibleText(country, dropDown);
		log.info("Country Selected: "+ country);
	}
	
	public void checkBoxClick() {
		checkBox.click();
		log.info("Check Box Clicked");
	}
	
	public void proceedToCheckOutClick() {
		proceedToCheckOut.click();
		log.info("Clicked Proceed to checkout button");
	}

}
