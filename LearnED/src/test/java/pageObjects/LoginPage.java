package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class LoginPage {
	public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath="//*[@class='ui button']")
	@CacheLookup
	WebElement prelogin;
	
	
	@FindBy(xpath="//*[@class='MuiSvgIcon-root MuiAvatar-fallback']")
	@CacheLookup
	WebElement Profile;
	
	@FindBy(id="standard-required")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@type='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@type='button']")
	@CacheLookup
	WebElement btnLogin;
	
	
	@FindBy(xpath="//*[@class='appHeader_labelForIssue__2_07h'][1]")
	@CacheLookup
	WebElement ErrMsg1;
	
	
	@FindBy(xpath="//*[@class='appHeader_labelForIssue__2_07h'][2]")
	@CacheLookup
	WebElement ErrMsg2;
	
	@FindBy(xpath="//*[text() = 'Forgot password?']")
	@CacheLookup
	WebElement ForgotPassword;

	@FindBy(xpath="//*[@class = 'MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'][1]")
	@CacheLookup
	WebElement faq;
	
	@FindBy(xpath="//*[@id=\"simple-menu\"]/div[3]/ul/li")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUserName(String uname) {
		waitHelper.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public String UsernameErrMSG() {
		return ErrMsg1.getText();
	}
	
	public boolean UsernameErrMSG1() {
		return ErrMsg1.isDisplayed();
	}
	
	public String PasswordErrMSG() {
		return ErrMsg2.getText();
	}
	
	public boolean PasswordErrMSG1() {
		return ErrMsg2.isDisplayed();
	}
	
	
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void faq() {
		faq.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	public void preLogin() {
		prelogin.click();
	}
	
	public void findProfile() {
		Profile.click();
	}
	
	
	public void ForgotPassword() {
		ForgotPassword.click();
	}
}
