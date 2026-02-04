package com.united.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.united.base.BasePage;

public class CartPage extends BasePage {
	
	
	@FindBy(xpath = "//tbody/tr/td[5]/p[@class = 'amount']")
	private List<WebElement> cartAmountEle;
	
	@FindBy(xpath = "//*[@class = 'totAmt']")
	private WebElement totalAmount;
	
	@FindBy(xpath = "//*[text()='Place Order']")
	private WebElement placeOrderBtn;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public int getCartAmount() {
		int cartAmount = cartAmountEle.stream().
				map(ele -> Integer.parseInt(ele.getText())).collect(Collectors.summingInt(Integer::intValue));
		log.info("Cart Amount:" + cartAmount);
		return cartAmount;
		
	}
	
	public int getTotalAmount() {
		int totAmount = Integer.parseInt(totalAmount.getText());
		log.info("Cart Amount:" + totAmount);
		return totAmount;
	}
	
	public void clickOnCheckOut() {
		placeOrderBtn.click();
		log.info("CheckOut Butto clicked");
		
	}
}
