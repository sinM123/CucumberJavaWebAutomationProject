package com.united.stepdefinitions;

import org.testng.Assert;

import com.united.context.ScenarioContext;
import com.united.hooks.Hooks;
import com.united.pages.CartPage;

import io.cucumber.java.en.When;

public class CartPageSteps {
	
	CartPage cartPage;
	ScenarioContext context;
	
	public CartPageSteps (ScenarioContext context) {
		this.context = context;
	}
	
	@When("User proceeds to checkout")
	public void user_proceeds_to_checkout() {
		cartPage = new CartPage(Hooks.driver);
		Assert.assertEquals(cartPage.getCartAmount(), cartPage.getTotalAmount());
		cartPage.clickOnCheckOut();
		
	  
	}

}
