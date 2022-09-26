package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class Cousedetails {
public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public Cousedetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	
	


	@FindBy(xpath="(//*[@class='pro-item-content'])[2]")
	@CacheLookup
	WebElement MyprogramTab;
	
	@FindBy(xpath="(//*[@style = 'color: rgb(15, 128, 164);'])[1]")
	@CacheLookup
	WebElement ProgramName;
	
	@FindBy(xpath="//*[@class = 'slick-arrow slick-next']")
	@CacheLookup
	WebElement Navigator;
	
	
	@FindBy(xpath="//p[contains(text(),'Course with All objects')]")
	@CacheLookup
	WebElement CourseName;
	
	@FindBy(xpath="//*[@class = 'jss17']")
	@CacheLookup
	WebElement pathway;
	
	@FindBy(xpath="//strong[contains(text(),'Course with All objects')]")
	@CacheLookup
	WebElement CourseTitle;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")
	@CacheLookup
	WebElement CourseDuration;
	
	@FindBy(xpath="//p[contains(text(),'testing 1')]")
	@CacheLookup
	WebElement Course_discription;
	
	@FindBy(xpath="//a[contains(text(),'Course structure')]")
	@CacheLookup
	WebElement course_structure;
	
	
	@FindBy(xpath="//*[@class = 'size-m-b']")
	@CacheLookup
	WebElement Unit1;
	
	@FindBy(xpath="//*[@style = 'padding-left: 10px;']")
	@CacheLookup
	WebElement First_content;
	
	@FindBy(xpath="//*[text() = 'all the best']")
	@CacheLookup
	WebElement Created_HTMLcontent;
	
	@FindBy(xpath="//*[text() = 'Students & Community']")
	@CacheLookup
	WebElement Uploaded_HTMLcontent;
	
	@FindBy(xpath="//*[text() = 'Next']")
	@CacheLookup
	WebElement NextBTN;
	
	
	@FindBy(xpath="//*[text() = 'Prev']")
	@CacheLookup
	WebElement PrevBTN;
	
	@FindBy(xpath="//*[text() = 'Mark Complete']")
	@CacheLookup
	WebElement Mark_CompleteBTN;
	
	
	
	@FindBy(xpath="//*[@class = 'display-flex padding2']")
	@CacheLookup
	List <WebElement> ModuleName;
	
	public void Unit1() throws InterruptedException
	{
		Unit1.click();
		Thread.sleep(2000);
	}
	
	public void First_content() throws InterruptedException
	{
		First_content.click();
		Thread.sleep(5000);
		
		int size = ldriver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		
		ldriver.switchTo().frame(0);
		
		if(Created_HTMLcontent.isDisplayed() == true)
		{
			System.out.println("Created HTML content Displayed");
		}
		else
		{
			System.out.println("Failed to load Created HTML content");
		}
		
		ldriver.switchTo().defaultContent();
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(5000);	
		js.executeScript("window.scrollBy(0,5000)");
		
		NextBTN.click();
		
		ldriver.switchTo().frame(0);
		Thread.sleep(4000);
		
		if(Uploaded_HTMLcontent.isDisplayed() == true)
		{
			System.out.println("Uploaded HTML content Displayed");
		}
		else
		{
			System.out.println("Failed to load Uploaded HTML content");
		}
		ldriver.switchTo().defaultContent();

		NextBTN.click();
	}
	
	
	public void ModuleName() throws InterruptedException
	{
		for( WebElement module : ModuleName )
		{
			System.out.println(module.getText());
		}
	}
	
	public void ProgramName() throws InterruptedException
	{
		MyprogramTab.click();
		Thread.sleep(2000);
		ProgramName.click();
		
	}
	
	public void Navigator() throws InterruptedException
	{
		Navigator.click();
	}
	
	public void CourseName() throws InterruptedException
	{
		CourseName.click();
		Thread.sleep(5000);
	}
	
	
	public boolean coursenamedisplay()
	{
		return CourseName.isDisplayed();
	}
	
	
	
	
}
