Feature: ScenarioOutline feature
	
	Background: 
		Given This is Sample Backgtound scenario
		
	Scenario Outline: Navigate to Google page and search for some text
		Given Launch Browser
		Then Check for <Number>
		When Enter scenario to search for <TestData>
		Examples:
		|TestData|Number|
		|Scenario OutLine|10|
		|Scenario|20|
		
	
	Scenario Outline: Navigate to Google page and search for some text
		Given Launch Browser
		Then Check for <Number>
		When Enter scenario to search for <TestData>
		Examples:
		|TestData|Number|
		|Scenario OutLine|30|
		|Scenario|40|
		
	
	Scenario Outline: Navigate to Google page and search for some text
		Given Launch Browser
		Then Check for <Number>
		When Enter scenario to search for <TestData>
		Examples:
		|TestData|Number|
		|Scenario OutLine|50|
		|Scenario|60|
		
	
	Scenario Outline: Navigate to Google page and search for some text
		Given Launch Browser
		Then Check for <Number>
		When Enter scenario to search for <TestData>
		Examples:
		|TestData|Number|
		|Scenario OutLine|70|
		|Scenario|80|