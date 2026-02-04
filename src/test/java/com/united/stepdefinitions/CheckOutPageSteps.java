package com.united.stepdefinitions;

import org.testng.Assert;

import com.united.context.ScenarioContext;
import com.united.hooks.Hooks;
import com.united.pages.CheckoutPage;

import io.cucumber.java.en.When;

public class CheckOutPageSteps {
	
	CheckoutPage checkoutPage;
	ScenarioContext context;
	
	public CheckOutPageSteps (ScenarioContext context) {
		this.context = context;
	}
	
	@When("User completes checkout")
	public void user_completes_checkout() {
		
		checkoutPage = new CheckoutPage(Hooks.driver);
		System.out.println(checkoutPage.getPageTitle());
		Assert.assertEquals(checkoutPage.getPageTitle(), context.getData().getCheckoutTitle());
		checkoutPage.selectCountry("India");
		checkoutPage.checkBoxClick();
		checkoutPage.proceedToCheckOutClick();
		
	}

}
