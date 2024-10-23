package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		
		this.driver = ldriver;
		
	}
	
//	STORING THE WEBELEMENTS OF LOGIN PAGE FOR PAGE OBJECT MODEL //
	
	@FindBy(id="txtUsername") WebElement uid;
	
	@FindBy(name="txtPassword") WebElement pwd;
	
	@FindBy(xpath="//input[@id='btnLogin']") WebElement loginbutton;
	
	public void loginToOrangeHRM(String username, String password){
		
		try {
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {

			e.printStackTrace();
			
		}
		
		uid.sendKeys(username);
		
		pwd.sendKeys(password);
		
		loginbutton.click();
		
	}
	
}
