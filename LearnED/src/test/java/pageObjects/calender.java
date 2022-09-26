package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class calender {
public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public calender(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath="(//*[@class='pro-item-content'])[3]")
	@CacheLookup
	WebElement calender;
	
	@FindBy(xpath="//*[@style='margin-top: -22px; color: rgb(15, 128, 164); text-transform: capitalize;']")
	@CacheLookup
	List<WebElement>  totl_Events_announcemnets;
	
	
	
	@FindBy(xpath="//*[@class='Events_iconTop__2qshH']")
	@CacheLookup
	List<WebElement>  Event_week;
	
	@FindBy(xpath="//*[@class='Events_iconBottom__2Fp8n']")
	@CacheLookup
	List<WebElement>  Event_date;
	
	@FindBy(xpath="//*[@style='margin-top: -22px; color: rgb(15, 128, 164); text-transform: capitalize;']")
	@CacheLookup
	List<WebElement>  Event_title;
	@FindBy(xpath="//*[@rel='noreferrer']")
	@CacheLookup
	List<WebElement>  Event_link;
	
	


	public void calander_click() throws InterruptedException {
		
		calender.click();
		Thread.sleep(3000);
	}

	public void Events() throws InterruptedException {
		Thread.sleep(3000);
		int count = totl_Events_announcemnets.size();
		System.out.println(count + " Events listed in events tab ");
		Thread.sleep(4000);
		
		for(int i =0 ;i<=count-1 ;i++)
		{
			String week = Event_week.get(i).getText();
			String date = Event_date.get(i).getText();
			String details = Event_title.get(i).getText();
			String links= Event_link.get(i).getText();
			
			System.out.println(week +"-" + date +" : "+ details+" - "+links );
		}
		
		
		
	}
	
	

	
	
}
