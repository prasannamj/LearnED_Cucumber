package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.Cousedetails;
import pageObjects.DashBoard;
import pageObjects.FaqPage;
import pageObjects.ForgotPassword;
import pageObjects.LoginPage;
import pageObjects.Notificationpage;
import pageObjects.ResetPassword;
import pageObjects.calender;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public Notificationpage nc;
	public FaqPage faq;
	public DashBoard db;
	public Cousedetails cd;
	public calender cl;
	public ForgotPassword FP;
	public ResetPassword RP;
	public static Logger logger;
	public Properties configProp;
	
}
