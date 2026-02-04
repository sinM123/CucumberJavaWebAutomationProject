package com.united.stepdefinitions;

import org.testng.Assert;

import com.united.context.ScenarioContext;
import com.united.hooks.Hooks;
import com.united.pages.ThankYouPage;

import io.cucumber.java.en.Then;

public class ThankYouPageSteps {
	
	ThankYouPage thankyouPage;
	ScenarioContext context;
	
	public ThankYouPageSteps (ScenarioContext context) {
		this.context = context;
	}
	
	@Then("Order should be placed successfully")
	public void order_should_be_placed_successfully() {
		thankyouPage = new ThankYouPage(Hooks.driver);
		Assert.assertEquals(thankyouPage.getThankYouMessage(), context.getData().getThankYouMessage());
	    
	}
	

}
