package com.ScreenFunctions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void beforeScenario()
	{
		System.out.println("*************** This is Before Scenario Hook Method ***************");
	}
	
	@After
	public void afterScenario()
	{
		System.out.println("*************** This is After Scenario  Hook Method ***************");
	}
}
