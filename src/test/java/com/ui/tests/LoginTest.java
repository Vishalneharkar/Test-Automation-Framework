package com.ui.tests;

import static com.constant.Browser.*;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase
{ 
	/*
	 * Test Method !!1.Test Script small!
	 * 2.You can not have conditional statements,loops ,try catch in your test method TestScripts--->Test Steps
	 * 3.Reduce the use of local variables
	 * 4.At least one assertion should be there	* 
	 * 
	 */
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	@Test(description= "Verifies with the valid user is able to login into the application",
			groups= {"e2e","sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void loginTest(User user)
	{
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Vishal N");
	}
	/*@Test(description= "Verifies with the valid user is able to login into the application",
			groups= {"e2e","sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
	public void loginCSVTest(User user)
	{
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Vishal N");
	}
	
	@Test(description= "Verifies with the valid user is able to login into the application",
			groups= {"e2e","sanity"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
			)
	public void loginExcelTest(User user)
	{
		//Logger logger=LoggerUtility.getLogger(this.getClass());
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Vishal N");
		
	}
*/

}
