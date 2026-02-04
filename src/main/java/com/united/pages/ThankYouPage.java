package com.united.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.united.base.BasePage;

public class ThankYouPage extends BasePage{
	
	@FindBy(xpath = "//div[@class = 'wrapperTwo']/span")
	private WebElement thankYouMessage;
	

	public ThankYouPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getThankYouMessage() {
		isDisplayed(thankYouMessage);
		log.info("Thank you message displayed");
		return thankYouMessage.getText();
	}

}
