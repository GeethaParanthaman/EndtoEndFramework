package main;


import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import common.CommonMethods;
import pages.LoginPage;
import pages.SignUPPage;

public class SignUpTest extends CommonMethods {
	private ExtentReports extent;
	private ExtentTest test;
	@BeforeSuite
	public void setupReport()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
	}
	{
		
	}

	@BeforeMethod
	public void browserLaunch(Method method)
	{
		browserInitialization();
		test=extent.createTest(method.getName());
		
	}
@Test(priority = 1)
	public void signupFlow()
	{
	try {
	SignUPPage signupPageObj=new SignUPPage(driver);
	test.info("Clicking on Signup");
	signupPageObj.signUpClick();
	test.info("Filling sign up dilaog inputs");
	signupPageObj.signupDiaglog();
	test.info("Close broswer");
	browserClose();
	test.pass("SignUp completed successfully");
	}
	catch (Exception e) {
		// TODO: handle exception
		test.fail("Sign Up flow failed:  "+e.getMessage());
		throw e;
	}
	//switchAlert();
	//alertAccept();
	
	}
@Test(priority = 2)
public void loginFlow() {
	try {
	LoginPage loginObject=new LoginPage(driver);
	test.info("Click on Login button");
	loginObject.login();
	test.info("Filling input fields ");
	loginObject.logininputs();
	test.info("Login Confirmation");
	loginObject.loginCheck();
	test.info("Closing browser");
	browserClose();
	}
	catch (Exception e) {
		// TODO: handle exception
		test.info("Login flow failed: "+e.getMessage());
		throw e;
	}
}
	public void logTestResults(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(result.getMethod().getMethodName()+"Passed");
		
	}
		else if (result.getStatus()==ITestResult.FAILURE) {
			test.fail(result.getMethod().getMethodName()+"Failure" +result.getThrowable());
		}
			else if (result.getStatus()==ITestResult.SKIP) {
				test.skip(result.getMethod().getMethodName()+"Skipped");
				
			}
			
		}


@AfterSuite
public void flushReport() {
    extent.flush();
}
}
