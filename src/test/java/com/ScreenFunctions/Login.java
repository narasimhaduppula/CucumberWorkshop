package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.RunnerClass.TestNgRunnerClass;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends TestNgRunnerClass{
	@FindBy (how=How.ID,using = "txtUsername")
	public static WebElement Edi_Username;
	
	@FindBy (how=How.NAME,using = "txtPassword")
	public static WebElement Edi_Password;
	
	@FindBy (how=How.XPATH,using = "//input[@id='btnLogin']")
	public static WebElement Btn_Login;

	@FindBy (how=How.ID,using = "welcome")
	public static WebElement Lnk_Welcome;

	@FindBy (how=How.XPATH,using = "//a[text()='Logout']")
	public static WebElement Lnk_logout;
	
	public static boolean login(String Username, String Password)
	{
		boolean status = true;
		try{
			Edi_Username.sendKeys(Username);
			Edi_Password.sendKeys(Password);
			Btn_Login.click();
			//waitForelement (Lnk_Welcome);
			Lnk_Welcome.click();
			Thread.sleep(2000);
			//waitForelement (Lnk_logout);
			Lnk_logout.click();
			waitForelement(Btn_Login);
			logEvent("PASS","Login is successfull");
			}catch (Exception e){
				System.out.println("Login button is not found");
				test.log(LogStatus.FAIL, "Login is not successfully done");
				status = false;
			}
		
		return status;
	}
	
}
	
