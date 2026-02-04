package com.united.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.united.base.BasePage;

public class GroceriesPage extends BasePage {
	
	public GroceriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".products .product")
	private List<WebElement> productsEle;
	
	@FindBy(css = ".product-name")
	private List<WebElement> productNamesEle;
	
	private By addToCartBtn = By.cssSelector(".product-action");
	private By productName = By.cssSelector(".product-name");
	
	@FindBy(className = "cart-icon")
	private WebElement cartIcon;
	
	@FindBy(className = "cart-preview")
	private WebElement cartPreview;
	
	@FindBy(css = ".action-block")
	private WebElement checkOutBtn;
	
	@FindBy(css = ".empty-cart h2")
	private WebElement emptyCart;
	
	
	public void getAllProductNames() {
		List<String> productNames = productNamesEle.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info("Getting Product Names: " + productNames);
		
	}
	
	public void addToCart(List<String> veggies) {
		for (String veggie: veggies) {
			WebElement product = productsEle.stream().filter(ele -> ele.findElement(productName).
					getText().contains(veggie)).findFirst().orElse(null);
			product.findElement(addToCartBtn).click(); 
			log.info(veggie + " added to cart");
		}
		
	}
	
	public void checkOutToCart() {
		cartIcon.click();
		log.info("Cart Icon clicked");
		isDisplayed(cartPreview);
		checkOutBtn.click();
		log.info("Check out button clicked");
		
	}
	
	public String getEmptyCartText() {
		log.info("Empty Text message: " + emptyCart.getText());
		return emptyCart.getText();  
	}

}
