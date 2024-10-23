package com.framework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.framework.pages.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.utility.Helper;

public class LoginTest_OrangeHRM extends BaseClass{

	@Test(priority=1)
	public void loginApp(){
		
		logger = report.createTest("Login to OrangeHRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Browser started");
		
		loginPage.loginToOrangeHRM(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		
		logger.pass("Login Success");
		
	}
	
	
//	THIS IS A DUMMY TEST CASE AND WE MARKED IT AS FAIL JUST FOR THE REPORTING PURPOSE
	
//	@Test(priority=2)
//	public void logoutApp(){
//		
//		logger = report.createTest("Logout from OrangeHRM");
//		
//		logger.fail("Logout Failed");
//		
//	}
	
}
