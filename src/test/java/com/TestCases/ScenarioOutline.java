package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.RunnerClass.TestNgRunnerClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioOutline extends TestNgRunnerClass{
	@Given("^Launch Browser$")
	public void launch_Browser() throws Throwable {
		System.out.println("This is to Launch Browser");
	}

	@Then("^Check for (\\d+)$")
	public void check_for_TextBox(int num) throws Throwable {
		System.out.println("Text field is available --> "+num);
	}

	@When("^Enter scenario to search for ([^\"]*)$")
	public void enter_scenario_to_search_for(String str) throws Throwable {
		System.out.println("STring searching for --> "+str);
	}

	@Given("^This is Sample Backgtound scenario$")
	public void backgroundMethod()
	{
		System.out.println("*************This is Sample Background***********");
	}


}
