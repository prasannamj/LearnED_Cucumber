package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class ForgotPassword {

	
public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public ForgotPassword(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath="//*[text() = 'Forgot password? Please enter your email']")
	@CacheLookup
	WebElement ForgotPasswordTitle;
	
	
	@FindBy(xpath="//*[@class= 'MuiInputBase-input MuiInput-input']")
	@CacheLookup
	WebElement EmailIDField;
	
	@FindBy(xpath="//*[@class = 'appHeader_labelForIssue__2_07h']")
	@CacheLookup
	WebElement ErrorMessage;
	
	@FindBy(xpath="//*[@value = 'Next']")
	@CacheLookup
	WebElement NextBTN;
	
	
	
	public boolean ForgotPasswordTitle() {
		return ForgotPasswordTitle.isDisplayed();
	}
	
	public boolean EmailIDField() {
		return EmailIDField.isDisplayed();
	}
	
	public boolean ErrorMessage() {
		return ErrorMessage.isDisplayed();
	}
	
	public boolean NextBTN() {
		return NextBTN.isDisplayed();
	}
	
	
	
	
	public void EnterEmail(String NPassword) {
		EmailIDField.clear();
		EmailIDField.sendKeys(NPassword);
	}
	
	
	public void ClickNextBTN() {
		NextBTN.click();
	}
	
	
	public String EmailErrorMessage() {
		return ErrorMessage.getText();
	}
	
	
}
