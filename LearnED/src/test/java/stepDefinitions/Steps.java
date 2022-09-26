package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Cousedetails;
import pageObjects.DashBoard;
import pageObjects.FaqPage;
import pageObjects.ForgotPassword;
import pageObjects.LoginPage;
import pageObjects.Notificationpage;
import pageObjects.ResetPassword;
import pageObjects.calender;

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

	@SuppressWarnings("deprecation")
	@When("user opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("******** opening URL***********");
		driver.get(url);
	    Thread.sleep(5000);
	    lp.preLogin();
	    
	}

	@When("user Enters Email Id as {string} And password as {string}")
	public void user_enters_email_id_as_and_password_as(String email, String password) {
		
		logger.info("********Providing login details***********");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		logger.info("********Stratred login***********");
		lp.clickLogin();
	    Thread.sleep(10000);
	    if(driver.getPageSource().contains("User does not exist")) {
			
			Assert.assertTrue("User does not exist", lp.UsernameErrMSG().contains("User does not exist"));
			System.out.println("Error message displayed as = > " + lp.UsernameErrMSG());
			logger.info("******** login fail for invalid user ID***********");
			
			
		}else if(driver.getPageSource().contains("Please enter a valid email")){
			Assert.assertTrue("Please enter a valid email", lp.UsernameErrMSG().contains("Please enter a valid email"));
			System.out.println("Error message displayed as = > " + lp.UsernameErrMSG());
			logger.info("********login fail for blank credentials***********");
		
			
		}else if(driver.getPageSource().contains("Incorrect username or password"))
		{
			Assert.assertTrue("Incorrect username or password", lp.PasswordErrMSG().contains("Incorrect username or password"));
			System.out.println("Error message displayed as = > " + lp.PasswordErrMSG());
			logger.info("********login fail for invalid password***********");
			
		}
		else
		{
			logger.info("********login succesful for valid credentials***********");
		}
		
	}
	


	@When("user click on notification icon")
	public void user_click_on_notification_icon() throws InterruptedException {
		nc= new Notificationpage(driver);
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
		 Thread.sleep(5000);
		 logger.info("********User logging out***********");
		lp.findProfile();
		Thread.sleep(5000);
	    lp.clickLogout();
	   
	}

	@When("close browser")
	public void close_browser() {
		logger.info("********Closing the browser***********");
	    driver.quit();
	}
	
	

	@When("User Click on FAQ Link")
	public void user_click_on_faq_link() throws InterruptedException {
	
		Thread.sleep(3000);
	lp.findProfile();
	Thread.sleep(3000);
	logger.info("********user click on FAQ ***********");
	lp.faq();
	faq = new FaqPage(driver);
	
	}


	@Then("Read the Titles of the table with Number Of Question in Student tab")
	public void read_thye_titles_of_the_table_with_number_of_question_in_Student_tab() throws InterruptedException {
		logger.info("********Getting Students Questions in FAQS  ***********");
		faq.StudentQuestions();

	}


@Then("Read the Titles of the table with Number Of Question in Instructor tab")
public void read_the_titles_of_the_table_with_number_of_question_in_instructor_tab() throws InterruptedException {
	logger.info("********Getting Instructor Questions in FAQS  ***********");
	faq.InstructorQuestions();
}
@Then("Read the Titles of the table with Number Of Question in Program Coordinator tab")
public void read_the_titles_of_the_table_with_number_of_question_in_program_coordinator_tab() throws InterruptedException {
	logger.info("********Getting Program Coordinator Questions in FAQS  ***********");
	faq.ProgramCoordinatorQuestions();
}
@Then("Read the Titles of the table with Number Of Question in Admin tab")
public void read_the_titles_of_the_table_with_number_of_question_in_admin_tab() throws InterruptedException {
	logger.info("********Getting Admin Questions in FAQS  ***********");
	faq.AdminQuestions();
}



@When("user Click on ForgotPassword link")
public void user_click_on_forgot_password_link() throws InterruptedException {
	lp.ForgotPassword();
	logger.info("********Forgot Password page is Displayed***********");
	FP = new ForgotPassword(driver);
	
	Thread.sleep(2000);
	System.out.println( "Forgot Password page Title Displayed = > "+FP.ForgotPasswordTitle());
	System.out.println("Forgot Password page Email ID Field Displayed = > " + FP.EmailIDField());
	System.out.println("Forgot Password page NEXT Button is Displayed = > " + FP.NextBTN());

	
}
@When("user Enters Email Id as {string}")
public void user_enters_email_id_as(String Email) throws InterruptedException {
	
	logger.info("********Entering Email ID in Forgot Password Page***********");
	FP.EnterEmail(Email);
	Thread.sleep(2000);
	
}
@When("click on Next Button")
public void click_on_next_button() throws InterruptedException {
	
	logger.info("********Clicking NExt Button in Forgot Password Page***********");
	FP.ClickNextBTN();
	Thread.sleep(2000);
}

@When("verify Forgot Passowrd page Error Messages")
public void verify_forgot_passowrd_page_error_messages() throws InterruptedException {
  
	Thread.sleep(2000);
	if(driver.getPageSource().contains("Please enter a valid email")) {
		
		Assert.assertTrue("Please enter a valid email", FP.EmailErrorMessage().contains("Please enter a valid email"));
		System.out.println("Error message displayed for Blank Email ID = > " + FP.EmailErrorMessage());
		logger.info("******** Error message displayed for Blank Email ID ***********");
		
		
	}else if(driver.getPageSource().contains("Username/client id combination not found.")){
		Assert.assertTrue("Username/client id combination not found.", FP.EmailErrorMessage().contains("Username/client id combination not found."));
		System.out.println("Error message displayed for Invalid Email ID = > " +FP.EmailErrorMessage());
		logger.info("********Error message displayed for Invalid Email ID***********");
	}
	else
	{
		Assert.assertTrue("Password Reset", RP.Text11().contains("Password Reset"));
		System.out.println("Naviagated to reset PAssword page");
		logger.info("********Naviagated to reset PAssword page ***********");
	}
	

}


@When("verify Reset password page Displayed or not")
public void verify_reset_password_page_displayed_or_not() throws InterruptedException {
	
	Thread.sleep(3000);
       RP = new ResetPassword(driver);
      if(RP.VerificationCode() == true)
      {
    	  System.out.println("reset Password screen is Displayed ");
      }
      else
      {
    	  System.out.println("reset Password screen is not Displayed");
      }
}
@When("verify Reset password page UI")
public void verify_reset_password_page_ui() throws InterruptedException {
    
	Thread.sleep(3000);
	 if(RP.Text1() && RP.Text2() == true)
     {
   	  System.out.println("reset Password screen Title is Displayed ");
     }else
     {
    	 System.out.println("reset Password screen Title is not Displayed ");
     }
	 
	 if(RP.VerificationCode() == true)
     {
   	  System.out.println("reset Password screen VerificationCode fields is Displayed ");
     }else
     {
    	 System.out.println("reset Password screen VerificationCode fields is not Displayed ");
     }
	 
	 if(RP.NewPassword() == true)
     {
   	  System.out.println("reset Password screen NewPassword fields is Displayed ");
     }else
     {
    	 System.out.println("reset Password screen NewPassword fields is not Displayed ");
     }
	 
	 if(RP.Confirm_password() == true)
     {
   	  System.out.println("reset Password screen Confirm_password fields is Displayed ");
     }else
     {
    	 System.out.println("reset Password screen Confirm_password fields is not Displayed ");
     }
	 
	 if(RP.PasswordNoteMSG() == true)
     {
   	  System.out.println("reset Password screen Password instruction MSG  is Displayed ");
     }else
     {
    	 System.out.println("reset Password screen Password instruction MSG is not Displayed ");
     }
	 
	 if(RP.SubmitBTN()== true)
     {
   	  System.out.println("reset Password screen Submit BTN  is Displayed ");
     }else
     {
    	 System.out.println("reset Password screen Submit BTN is not Displayed ");
     }
	
	
}
@When("verify Reset password page Error messages")
public void verify_reset_password_page_error_messages() throws InterruptedException {
    
	Thread.sleep(2000);
	RP.RPSubmitBTN();
	Thread.sleep(2000);
	if(driver.getPageSource().contains("Please enter the code")) {
		
		Assert.assertTrue("Please enter the code", RP.RPError11().contains("Please enter the code"));
		System.out.println("Error message displayed for Verification code = > " + RP.RPError11());
		logger.info("******** Error message displayed for Verification code ***********");
		RP.EnyterVerificationcode("123456");
		RP.RPSubmitBTN();
		Thread.sleep(2000);
		
		if(driver.getPageSource().contains("Please enter a password")){
			Assert.assertTrue("Please enter a password.", RP.RPError12().contains("Please enter a password"));
			System.out.println("Error message displayed for new Password field= > " +RP.RPError12());
			logger.info("********Error message displayed for new Password field***********");
			RP.EnyterNewPassword("qwerty@1");
			RP.RPSubmitBTN();
			Thread.sleep(2000);
			
			if(driver.getPageSource().contains("Please enter a Confirmation password")){
				Assert.assertTrue("Please enter a Confirmation password", RP.RPError13().contains("Please enter a Confirmation password"));
				System.out.println("Error message displayed for Confirm Password field= > " +RP.RPError13());
				logger.info("********Error message displayed for Confirm Password field***********");
				RP.EnterConfirmPassword("qwerty@12");
				RP.RPSubmitBTN();
				Thread.sleep(2000);
				
				if(driver.getPageSource().contains("Passwords don't Match!")){
					Assert.assertTrue("Passwords don't Match!", RP.RPError14().contains("Passwords don't Match!"));
					System.out.println("Error message displayed for invalid password fields= > " +RP.RPError14());
					logger.info("********Error message displayed for invalid  Password field***********");
					RP.EnterConfirmPassword("qwerty@1");
					RP.RPSubmitBTN();
					Thread.sleep(2000);
					
					if(driver.getPageSource().contains("Code mismatch")){
						Assert.assertTrue("Code mismatch", RP.RPError15().contains("Code mismatch"));
						System.out.println("Error message displayed for invalid Verification code = > " +RP.RPError15());
						logger.info("********Error message displayed for invalid  Verification code ***********");
						Thread.sleep(3000);
						
						//Email code need to be written
					}
				}
			}
		}
		
		
		}
	else
	{
		
		System.out.println("Reset password Screen Error messages are not Displayed");
		logger.info("********Reset password Screen Error messages are not Displayed ***********");
	}
	
}
@When("Check Reset password Functionality")
public void check_reset_password_functionality() throws InterruptedException {
	Thread.sleep(3000);
    System.out.println("Pending");
}


@When("click on program name in Announcements")
public void click_on_program_name_in_announcements() throws InterruptedException {
	db = new DashBoard(driver);
	logger.info("********Announcements tab testing  started ***********");
	db.Announcemnts_programs();
	logger.info("********Announcements tab testing  Ended ***********");
	
}


@When("Read all events")
public void read_all_events() throws InterruptedException {
	db = new DashBoard(driver);
	logger.info("********Events tab testing  started ***********");
	db.Events();
	logger.info("********Events tab testing  Ended ***********");
	
}



@When("click on calendar tab")
public void click_on_calendar_tab() throws InterruptedException {
	cl = new calender(driver);
	db = new DashBoard(driver);
	Thread.sleep(4000);
//	db.calendar();
	cl.calander_click();
	Thread.sleep(4000);
	cl.Events();
	
}

@Then("click on program")
public void click_on_program() throws InterruptedException {
	cd = new Cousedetails(driver);
	Thread.sleep(3000);
	cd.ProgramName();
	Thread.sleep(3000);
    
}
@Then("Select Course")
public void select_course() throws InterruptedException {
	cd = new Cousedetails(driver);
	for(int i =0; i<=10;i++)
	{
		
		if(cd.coursenamedisplay()==true)
		{
			cd.CourseName();
			break;
		}
		else
		{
			Thread.sleep(2000);
			cd.Navigator();
		}
	}
	
}

@Then("View course content")
public void view_course_content() throws InterruptedException {
   
	cd.Unit1();
	cd.ModuleName();
	Thread.sleep(4000);
	cd.First_content();
	
}

}





