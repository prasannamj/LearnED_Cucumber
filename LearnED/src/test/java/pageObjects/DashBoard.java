package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class DashBoard {
public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public DashBoard(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	
	

	@FindBy(xpath="//*[@class = 'MuiButtonBase-root MuiAccordionSummary-root']")
	@CacheLookup
	List <WebElement> Announcements_Programs;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/div[1]/span[2]/a[1]")
	@CacheLookup
	WebElement calendar;
	
	@FindBy(xpath="//*[@class = 'MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock']")
    @CacheLookup
    List <WebElement> Announcements_date;
	
	@FindBy(xpath="//*[@class = 'MuiTypography-root MuiListItemText-secondary MuiTypography-body2 MuiTypography-colorTextSecondary MuiTypography-displayBlock']")
    @CacheLookup
    List <WebElement> Announcements_details;
	
	@FindBy(xpath="//*[@class='Dashboard_iconTop__apiwc']")
	@CacheLookup
	List <WebElement> Events_week;
	
	@FindBy(xpath="//*[@class='Dashboard_iconBottom__2I3ne']")
	@CacheLookup
	List <WebElement> Events_date;
	
	
	@FindBy(xpath="//*[@style='margin-top: -22px; color: rgb(15, 128, 164); text-transform: capitalize;']")
	@CacheLookup
	List <WebElement> Events_details;
	
	@FindBy(xpath="//*[@rel='noreferrer']")
	@CacheLookup
	List <WebElement> Events_link;
	
	
	@FindBy(xpath="(//*[@class='pro-item-content'])[2]")
	@CacheLookup
	WebElement Myprogram;
	
	
	
	public void Myprogram()
	{
		Myprogram.click();
	}
	
	public void calendar()
	{
		calendar.click();
	}
	
	public void Announcemnts_programs() throws InterruptedException
	{
		Thread.sleep(3000);
		int count = Announcements_Programs.size();
		System.out.println(count + " program listed in announcements ");
		
		Thread.sleep(4000);
		
		for(int i = 0;i<=count-1 ;i++)
		{
			String announcements = Announcements_Programs.get(i).getText();
			System.out.println("program name : " + announcements);
			
			Announcements_Programs.get(i).click();
			
			Thread.sleep(5000);
			
			int announcement_count = Announcements_date.size();
			System.out.println(announcement_count + " Announcements present" );
			
			
			for(int j= 0; j<=announcement_count-1; j++)
			{
				String date = Announcements_date.get(j).getText();
				String Discription = Announcements_details.get(j).getText();
				
				System.out.println(date +" "+Discription);
			}
			
			
		}
	}
	
	
	public void Events()throws InterruptedException
	{
		Thread.sleep(3000);
		int count = Events_details.size();
		System.out.println(count + " Events listed in events tab ");
		Thread.sleep(4000);
		
		for(int i = 0;i<=count-1 ;i++)
		{
			String week = Events_week.get(i).getText();
			String date = Events_date.get(i).getText();
			String details = Events_details.get(i).getText();
			String links= Events_link.get(i).getText();
			
			System.out.println(week +"-" + date +" : "+ details+" - "+links );
		}
	}
	
	
}
