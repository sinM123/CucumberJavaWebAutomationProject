package com.united.data;

import java.util.List;

public class OrderData {
	
	private List<String> veggies;
	private String checkoutTitle;
	private String thankYouMessage;
	
	public List<String> getVeggies() {
		return veggies;
	}
	
	public String getCheckoutTitle() {
		return checkoutTitle;
	}
	
	public String getThankYouMessage() {
		return thankYouMessage;
	}
	public void setVeggies(List<String> veggies) {
		this.veggies = veggies;
	}
	
	public void setCheckoutTitle(String checkoutTitle) {
		this.checkoutTitle = checkoutTitle;
	}
	
	public void setThankYouMessage(String thankYouMessage) {
		this.thankYouMessage = thankYouMessage;
	}
	
	

}
