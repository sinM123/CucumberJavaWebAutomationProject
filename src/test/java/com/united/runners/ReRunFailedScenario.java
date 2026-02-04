package com.united.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= "@target/rerun.txt",
		glue = {"com.united.hooks", "com.united.stepdefinitions"},
		plugin = {
			"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
				}
		)
public class ReRunFailedScenario extends AbstractTestNGCucumberTests {

}
