package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.Notification;

public class Steps extends BaseClass {
	
	@Before
	public void setup() throws IOException
	{
		

		logger=Logger.getLogger("LearnED_Cucuber");//added logger
		PropertyConfigurator.configure("log4j.properties");// logger has been added
		
		//reading properties
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		String BR = configProp.getProperty("browser");
		
		if(BR.equals("Chrome"))
		{
			logger.info("******** Launching chrome browser***********");
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}else if(BR.equals("FireFox"))
		{
			logger.info("******** Launching FireFox browser***********");
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if(BR.equals("IE"))
		{
			logger.info("******** Launching FireFox browser***********");
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
		
		
	}
	

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
		lp = new LoginPage(driver);
		//nc= new Notification(driver);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		driver.manage().window().maximize();
		logger.info("******** opening URL***********");
		driver.get(url);
	    Thread.sleep(5000);
	    
	}

	@When("user Enters Email Id as {string} And password as {string}")
	public void user_enters_email_id_as_and_password_as(String email, String password) {
		lp.preLogin();
		logger.info("********Providing login details***********");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		logger.info("********Stratred login***********");
		lp.clickLogin();
	    Thread.sleep(10000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("User does not exist")) {
			driver.quit();
			logger.info("******** login fail***********");
			Assert.assertTrue(false);
		}else {
			logger.info("********login pass***********");
			Assert.assertEquals(title,driver.getTitle());
		}
	}

	@When("user click on notification icon")
	public void user_click_on_notification_icon() throws InterruptedException {
		nc= new Notification(driver);
		logger.info("********User clicks on notification icon***********");
		Thread.sleep(3000);
		nc.clickNotification();
		Thread.sleep(5000);
	   
	}
	@Then("count the number notification")
	public void count_the_number_notification() {
		logger.info("********Count the number of notifications***********");
		nc.notificationCount();
	  
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		 Thread.sleep(10000);
		 logger.info("********User logging out***********");
		lp.findProfile();
	    lp.clickLogout();
	   
	}

	@When("close browser")
	public void close_browser() {
		logger.info("********Closing the browser***********");
	    driver.quit();
	}


}
