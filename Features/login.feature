Feature: Validate the E2E functionality of the login
	@SmokeTest
	Scenario: As per US0001, i need to validate the admin credentials with valid inout data
	Given Launch the Firefox Browser
	And Enter URL
	Then Maximize the Browser
	When It Maximize Verify the User name is available
	And Username is available enter the admin credentials
	|user01|pass1234|
	And This is to Test Variable "Var1"
	
	@SmokeTest @Regression
	Scenario: As per US0002, i need to validate the admin credentials with valid inout data
	Given Launch the Firefox Browser
	And Enter URL
	Then Maximize the Browser
	When It Maximize Verify the User name is available
	And Username is available enter the admin credentials
	|user01|pass1234|
	And This is to Test Variable "Var3"