package com.united.hooks;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.united.base.DriverFactory;
import com.united.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	protected static Logger log = LogManager.getLogger(Hooks.class);
	
	@Before
	public void setUp() throws IOException {
		ConfigReader.readConfigFile();
		log.info("===========Test execution started==========");
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(ConfigReader.getProperty("browser"));
		driver.get(ConfigReader.getProperty("url"));
		log.info("Browser Launched");
		driver.manage().window().maximize();
		log.info("Browser maximised");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Long.parseLong(ConfigReader.getProperty("timeouts"))));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		log.info("==========Test execution ended==========");
		driver.quit();
		log.info("Browser Closed");
	}
	

}
