package com.framework.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){
		
		if(browserName.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./Webdrivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")){
			
			System.setProperty("webdriver.gecko.driver", "./Webdrivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", "./Webdrivers/IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			
		}
		
		else{
			
			System.out.println("Sorry!! We don't supprt this browser !!");
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(appURL);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver){
		
		driver.quit();
		
	}
	
}
