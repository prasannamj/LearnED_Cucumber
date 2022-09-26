package pageObjects;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Notificationpage {
public WebDriver ldriver;
	
	public Notificationpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//*[@class='header__icon']")
	@CacheLookup
	WebElement notify;
	

	@FindBy(xpath="//*[@class = 'MuiListItem-root MuiListItem-gutters']")
    @CacheLookup
    List<WebElement> notifi_count;
	
	

	@FindBy(xpath="//div[@style = 'font-size: 15px;']")
    @CacheLookup
    List<WebElement> notification;
	
	
	
	public void clickNotification() throws InterruptedException {
		Thread.sleep(5000);;
		notify.click();
		Thread.sleep(7000);
	}
	
	public void notificationCount() {
		int nCount = notifi_count.size();
		System.out.println("Total number of Notifications : " + nCount);
		
		for(int i=0;i<=nCount-1;i++)
		{
			System.out.println(notification.get(i).getText());
		}
	}
}
