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
	
	public void clickLogin() {
		btnLogin.click();
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
}
