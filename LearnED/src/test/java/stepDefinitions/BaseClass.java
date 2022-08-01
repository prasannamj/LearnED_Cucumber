package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import pageObjects.LoginPage;
import pageObjects.Notification;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public Notification nc;
	public static Logger logger;
	public Properties configProp;
	
}
