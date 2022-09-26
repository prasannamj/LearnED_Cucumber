package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class FaqPage {
	
public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public FaqPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath="//*[@class = 'landingScreen_faqlink__2-hrA']")
	@CacheLookup
	WebElement FAQLink;
	
	@FindBy(xpath="//*[@class = 'Faq_heading__3XhWk']")
	@CacheLookup
	WebElement FAQPageTitle;
	
	@FindBy(xpath="//*[text()= 'Student']")
	@CacheLookup
	WebElement StudentTAB;

	@FindBy(xpath="//*[text()= 'Instructor']")
	@CacheLookup
	WebElement InstructorTAB;
	
	@FindBy(xpath="//*[text()= 'Program Coordinator']")
	@CacheLookup
	WebElement PCTAB;
	
	@FindBy(xpath="//*[text()= 'Admin']")
	@CacheLookup
	WebElement AdminTAB;
	
	@FindBy(xpath="//*[@class= 'MuiPaper-root MuiAccordion-root MuiAccordion-rounded MuiPaper-elevation1 MuiPaper-rounded']")
    @CacheLookup
    List<WebElement>StudentFAQs;
	
	@FindBy(xpath="//*[@class= 'MuiPaper-root MuiAccordion-root MuiAccordion-rounded MuiPaper-elevation1 MuiPaper-rounded']")
    @CacheLookup
    List<WebElement>InstructorFAQs;
	
	@FindBy(xpath="//*[@class= 'MuiPaper-root MuiAccordion-root MuiAccordion-rounded MuiPaper-elevation1 MuiPaper-rounded']")
    @CacheLookup
    List<WebElement>PCFAQs;
	
	@FindBy(xpath="//*[@class= 'MuiPaper-root MuiAccordion-root MuiAccordion-rounded MuiPaper-elevation1 MuiPaper-rounded']")
    @CacheLookup
    List<WebElement>AdminFAQs;
	
	
	public void clickFAQ() throws InterruptedException {
		FAQLink.click();


	}
	
	public boolean FAQPageTitle()
	{
		return FAQPageTitle.isDisplayed();
	}
	
	public boolean StudentTAB()
	{
		return StudentTAB.isDisplayed();
	}
	
	public boolean InstructorTAB()
	{
		return InstructorTAB.isDisplayed();
	}
	
	public boolean PCTAB()
	{
		return PCTAB.isDisplayed();
	}
	
	public boolean AdminTAB()
	{
		return AdminTAB.isDisplayed();
	}
	
	public void StudentQuestions() throws InterruptedException
	{

		waitHelper.waitForElement(StudentTAB, 20);
		StudentTAB.click();
		Thread.sleep(5000);
		int  SQCount = StudentFAQs.size();
		System.out.println("Number of Question Present in Student TAb = > " + SQCount);
		
		for(int i=0;i<=SQCount-1;i++)
		{
			String Question = StudentFAQs.get(i).getText();
			System.out.println(Question);
		}
				
	}
	
	public void InstructorQuestions() throws InterruptedException
	{
		InstructorTAB.click();
		int  IQCount = InstructorFAQs.size();
		System.out.println("Number of Question Present in Instructor TAb = > " + IQCount);
		
		for(int j=0;j<=IQCount-1;j++)
		{
			String Question = InstructorFAQs.get(j).getText();
			System.out.println(Question);
		}
				
	}
	
	public void ProgramCoordinatorQuestions() throws InterruptedException
	{
		PCTAB.click();
		int  PCQCount = PCFAQs.size();
		System.out.println("Number of Question Present in Program Coordinator TAb = > " + PCQCount);
		
		for(int k=0;k<=PCQCount-1;k++)
		{
			String Question = PCFAQs.get(k).getText();
			System.out.println(Question);
		}
				
	}
	
	public void AdminQuestions() throws InterruptedException
	{
		AdminTAB.click();
		int  AQCount = AdminFAQs.size();
		System.out.println("Number of Question Present in Admin TAb = > " + AQCount);
		
		for(int l=0;l<=AQCount-1;l++)
		{
			String Question = AdminFAQs.get(l).getText();
			System.out.println(Question);
		}
				
	}
	
	
}
