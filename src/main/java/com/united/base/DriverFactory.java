package com.united.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	WebDriver driver;
	
	public WebDriver initDriver(String browser) {  
		switch(browser) {
		case "Edge": 
			driver = new EdgeDriver();
			break;
		case "Chrome": 
			driver = new ChromeDriver();
			break;
		case "FireFox": 
			driver = new FirefoxDriver();
			break;
		default:
			driver = new EdgeDriver();
		
		}
		
		return driver;
				
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	
}

