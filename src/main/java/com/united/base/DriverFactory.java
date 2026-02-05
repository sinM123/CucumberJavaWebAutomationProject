package com.united.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			driver = setChromeOptions();
			break;
		case "FireFox": 
			driver = new FirefoxDriver();
			break;
		default:
			driver = new EdgeDriver();
		
		}
		
		return driver;
				
	}
	
	public static WebDriver setChromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		boolean isCi = Boolean.parseBoolean(System.getenv().getOrDefault("CI", "false"));
		
		if(isCi) {
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
		}
		
		return new ChromeDriver(options);
		
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	
}

