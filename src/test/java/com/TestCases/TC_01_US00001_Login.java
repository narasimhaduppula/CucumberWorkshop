package com.TestCases;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.RunnerClass.TestNgRunnerClass;
import com.ScreenFunctions.Login;
import com.codoid.products.exception.FilloException;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_01_US00001_Login extends TestNgRunnerClass {

	@Given("^Launch the Firefox Browser$")
	public void launch_the_Firefox_Browser() throws Throwable {
		initializeReport("TC_01_US00001_Login");
		startTest_Report();
	}

	@Then("^Enter URL$")
	public void enter_URL() throws Throwable {
		String url = getUrlFromExcel("Sheet1","yes");
		driver.get(url);
	}
	
	
	@Then("^Maximize the Browser$")
	public void maximize_the_Browser() throws Throwable {
	    driver.manage().window().maximize();
	}

	@When("^It Maximize Verify the User name is available$")
	public void it_Maximize_Verify_the_User_name_is_available() throws Throwable {
		
	}

	@When("^Username is available enter the admin credentials$")
	public void username_is_available_enter_the_admin_credentials(DataTable credentials) throws FilloException  {
		
		List<List<String>> cred = credentials.raw();
		System.out.println(cred.size());
		
		//createExcelConnection();
		
		//getting all the Test DAta from Excel
		int itrcount = getIterationCount("TestCases","TC_0001");
		for (int j=1;j<itrcount;j++){
			String username = getDataFromExcel ("TestCases","Username","TC_0001",j);
			String password = getDataFromExcel ("TestCases","Password","TC_0001",j);
			System.out.println("****************************************");
			System.out.println("Excel Record Data : "+ username);
			System.out.println("Excel Record Data : "+ password);
			System.out.println("****************************************");
		}
		String username = getDataFromExcel ("TestCases","Username","TC_0001",1);
		String password = getDataFromExcel ("TestCases","Password","TC_0001",1);
		System.out.println("****************************************");
		System.out.println("Excel Record Data : "+ username);
		System.out.println("Excel Record Data : "+ password);
		System.out.println("****************************************");
		System.out.println("****************** Cucumber Data Table Values Reading *********************");
		
		for(int i=0;i<cred.size();i++)
		{
			System.out.println(cred.get(i).get(0));
			System.out.println(cred.get(i).get(1));
			String uname = cred.get(i).get(0);
			String pwd = cred.get(i).get(1);
			Login ln= PageFactory.initElements(driver,Login.class);
			ln.login(uname, pwd);
		}
	}
	
	@When("^This is to Test Variable \"([^\"]*)\"$")
	public void this_is_to_Test_Variable(String arg1) throws Throwable {
		System.out.println(arg1);
	}
	
	@When("^Verify the user is navigated to home page$")
	public void verify_the_user_is_navigated_to_home_page() throws Throwable {
	}
}
