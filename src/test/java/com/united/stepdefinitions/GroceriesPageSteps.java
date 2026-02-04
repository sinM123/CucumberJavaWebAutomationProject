package com.united.stepdefinitions;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.united.context.ScenarioContext;
import com.united.data.OrderData;
import com.united.hooks.Hooks;
import com.united.pages.GroceriesPage;
import com.united.utils.ExcelUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GroceriesPageSteps {
	
	GroceriesPage groceriesPage;
	OrderData data;
	ScenarioContext context;
	
	public GroceriesPageSteps (ScenarioContext context) {
		this.context = context;
	}
	
	Logger log = LogManager.getLogger(GroceriesPageSteps.class);
	
	@Given("User opens Green Kart Page")
	public void user_opens_green_kart_page() {
		groceriesPage = new GroceriesPage(Hooks.driver);
		groceriesPage.getAllProductNames();
	}
	
	@When("User adds vegetables to cart")
	public void user_adds_vegetables_to_cart(DataTable table) {
		groceriesPage.addToCart(table.asList());
		groceriesPage.checkOutToCart();
		
	}
	
	
	@When("User clicks on checkout without adding items")
	public void user_clicks_on_checkout_without_adding_items() {
		groceriesPage.checkOutToCart();
	    
	}

	@Then("User should see empty cart message")
	public void user_should_see_empty_cart_message() {
		Assert.assertEquals(groceriesPage.getEmptyCartText(), "You cart is empty!");
	    
	}
	

	@When("User orders vegetables from excel {string}")
	public void user_orders_vegetables_from_excel(String testCaseId) {
		try {
			data = ExcelUtils.readExcelUtil(testCaseId);
			context.setData(data);
		} catch (IOException e) {
			log.error("error message: " + e);
		}
		groceriesPage.addToCart(data.getVeggies());
		groceriesPage.checkOutToCart();
		
	}
	
	@When("User adds vegetables from json")
	public void user_adds_vegetables_from_json() {
	    
	}


}
