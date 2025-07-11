package com.ui.tests;

import static com.constant.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constant.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LmbdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger=LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTest;

	
	@Parameters({"browser","isLamdaTest","isHeadless"})
	@BeforeMethod(description="Load the homepage of the website")
	public void setup(
			@Optional("chrome")String browser,
			@Optional("false")boolean isLamdaTest,
			@Optional("true")boolean isHeadless,ITestResult result)
	{	
		this.isLamdaTest=isLamdaTest;
		WebDriver lambdaDriver;
		if(isLamdaTest)
		{
			lambdaDriver=LmbdaTestUtility.intializeLambdaTestSession(browser,result.getMethod().getMethodName());
			homePage =new HomePage(lambdaDriver);
		}
		else {
		//Running the test on local machine
		logger.info("Load the homepage of the website");
		homePage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}

	public BrowserUtility getInstance()
	{
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown()
	{
		if(isLamdaTest)
		{
			LmbdaTestUtility.quitSession();//quit or close the all session on Lambda Test
		}
		else
		{
			homePage.quit(); //quit the session on local machine
		}
	}
}
