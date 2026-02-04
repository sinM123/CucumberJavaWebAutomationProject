package com.united.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= "src/test/resources/features",
		glue = {"com.united.hooks", "com.united.stepdefinitions"},
		plugin = {
			"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			"rerun:target/rerun.txt"
			}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	

}
