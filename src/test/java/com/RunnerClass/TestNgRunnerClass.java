package com.RunnerClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utililties.Utilities;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.*;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		strict = true,
		monochrome= true,
		features = "Features/login.feature",
		glue = "com.TestCases",
		plugin = {"pretty","html:target/cucumber-html-report"},
		tags = {"@SmokeTest"}
		
	)
public class TestNgRunnerClass extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Connection connection;
	public static Recordset recordset;
	public static Fillo fillo;
	public static String resultpath;

	
	@BeforeSuite
	public static void connectExcelFile() throws FilloException
	{
		createExcelConnection();
		resultpath = Utilities.createResultFolder();
		
	}
	
	@BeforeTest
	public static void startTest()
	{
		System.out.println("Starting Test Execution");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		
	}
	
	@AfterTest
	public static void endTest()
	{
		extent.endTest(test);
		driver.close();
		extent.flush();
	}
	
	public static void startTest_Report()
	{
		test = extent.startTest("Test Execution status");
	}
//	@AfterSuite
//	public static void flushreport()
//	{
//		extent.flush();
//		//driver.close();
//	}
	public static String TakeScreenshot()
	{
		String path ="";
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		TakesScreenshot tss = (TakesScreenshot)driver;
		String print = tss.getScreenshotAs(OutputType.BASE64);
		return "data:image/jpg;base64, "+print;
	}
//****************************************************************************************************************//
	/*
	 * Method Name	:	waitForelement
	 * Purpose		:	This method is developed to maintain a constant wait across all the pages and elements
	 * Input Parameters	:	User must send the Wenbelement as an Argument
	 * Output Parameters:	NA
	 * Designed By		:
	 * Creation Date	:
	 * Reviewed By		:
	 * Comments			:
	 * Modified Date	:
	 */
//****************************************************************************************************************//
	public static void waitForelement (WebElement element)
	{
		
		for(int i=0;i<=10;i++)
		{
			//Try to perform mouse hovering action on a WebElement
			try{
				
				System.out.println("Wait is execution");
				Actions acts = new	Actions(driver); 
				acts.moveToElement(element).build().perform();
				System.out.println("Wait is completed and element found");
				//if an element is found just break the execution loop
				break;
				
				
			}catch(Exception e){
				//If an element not found then wait for 1 second
				try{
					Thread.sleep(1000);
				}catch(Exception e1){
					
				}
			}
		}
			
	}
	//****************************************************************************************************************//
		/*
		 * Method Name		:	handlingExcelData
		 * Purpose			:	This method is developed to maintain a constant wait across all the pages and elements
		 * Input Parameters	:	User must send the Wenbelement as an Argument
		 * Output Parameters:	NA
		 * Designed By		:
		 * Creation Date	:
		 * Reviewed By		:
		 * Comments			:
		 * Modified Date	:
		 */
	//****************************************************************************************************************//
	public static void createExcelConnection() throws FilloException
	{
		String filepath = System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
		fillo=new Fillo();
		try{
			connection=fillo.getConnection(filepath);
			System.out.println("************ Connection Established Sucessfully************");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		 

		
	}
//****************************************************************************************************************//
		/*
		 * Method Name		:	getDataFromExcel
		 * Purpose			:	Get the data from Excel for a particular
		 * Input Parameters	:	Sheetname, Fieldname,TestCaseName, itr
		 * Output Parameters:	NA
		 * Designed By		:
		 * Creation Date	:
		 * Reviewed By		:
		 * Comments			:
		 * Modified Date	:
		 */
	//****************************************************************************************************************//

	public static String getDataFromExcel( String sheetname, String fieldname, String testcasename, int itr ) 
	{
		 String data = "";
		try{
			String strQuery="Select "+ fieldname + " from "+ sheetname +" where TC_Name='"+ testcasename +"' and Iteration = "+ itr;
			System.out.println(strQuery);
			recordset=connection.executeQuery(strQuery);
			System.out.println(recordset.getCount());
			while(recordset.next()){
				System.out.println("Username Field Value --> "+recordset.getField(fieldname));
				data = recordset.getField(fieldname);
				break;
			}
			
			
		}catch(Exception e){
			System.out.println("No Records found");
		}
		finally{
			recordset.close();
		}
		return data;
	}

	//****************************************************************************************************************//
			/*
			 * Method Name		:	getIterationCount
			 * Purpose			:	Get the iteration count from Excel for a particular
			 * Input Parameters	:	Sheetname, TestCaseName, 
			 * Output Parameters:	NA
			 * Designed By		:
			 * Creation Date	:
			 * Reviewed By		:
			 * Comments			:
			 * Modified Date	:
			 */
		//****************************************************************************************************************//
	public static int getIterationCount( String sheetname, String testcasename ) 
	{
		 int data=1;
		 try{
			 String strQuery="Select "+testcasename+" from "+sheetname;
			 recordset = connection.executeQuery(strQuery);
			 while(recordset.next())
			 {
				 data++;
			 }
		 }catch(Exception e)
		 {
			 System.out.println("No Records Found");
		 }
		 finally
		 {
			 recordset.close();
		 }
		return data;
	}
	//****************************************************************************************************************//
	/*
	 * Method Name		:	getIterationCount
	 * Purpose			:	Get the iteration count from Excel for a particular
	 * Input Parameters	:	Sheetname, ExecutionStatus 
	 * Output Parameters:	NA
	 * Designed By		:
	 * Creation Date	:
	 * Reviewed By		:
	 * Comments			:
	 * Modified Date	:
	 */
//****************************************************************************************************************//
	public static String getUrlFromExcel( String sheetname, String ExecutionStatus ) 
	{
		String data = "";
		try{
			String strQuery="Select browserurl from "+ sheetname +" where execution = '"+ExecutionStatus +"'";
			recordset = connection.executeQuery(strQuery);
			System.out.println(recordset.getCount());
			while(recordset.next())
			{
				data = recordset.getField("browserurl");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("No Records Found");
		}
		finally
		{
			recordset.close();
		}
		return data;
	}
	
	//****************************************************************************************************************//
	/*
	 * Method Name		:	initializeReport
	 * Purpose			:	Initializing the Extent report reference
	 * Input Parameters	:	Sheetname, ExecutionStatus 
	 * Output Parameters:	NA
	 * Designed By		:
	 * Creation Date	:
	 * Reviewed By		:
	 * Comments			:
	 * Modified Date	:
	 */
//****************************************************************************************************************//
	
	public static void initializeReport(String classname)
	{
		extent= new ExtentReports(resultpath+"\\"+classname+".html");
	}
	
	public static void logEvent(String status, String desc)
	{
		switch (status.toLowerCase())
		{
			case "pass" :
				test.log(LogStatus.PASS,desc+test.addBase64ScreenShot(TakeScreenshot()));
				break;
			case "fail":
				test.log(LogStatus.FAIL,desc+test.addBase64ScreenShot(TakeScreenshot()));
				break;
		}
	}
}