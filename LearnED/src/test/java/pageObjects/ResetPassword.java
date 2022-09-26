package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class ResetPassword {

public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public ResetPassword(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		waitHelper = new WaitHelper(ldriver);
	}
	

	@FindBy(xpath="//*[text() = 'Password Reset']")
	@CacheLookup
	WebElement Text1;
	@FindBy(xpath="//*[text() = 'Please enter the verification code sent to your email']")
	@CacheLookup
	WebElement Text2;
	@FindBy(xpath="//*[@placeholder = 'Verification Code']")
	@CacheLookup
	WebElement VerificationCode;
	@FindBy(xpath="//*[@placeholder = 'New password']")
	@CacheLookup
	WebElement NewPassword;
	@FindBy(xpath="//*[@placeholder = 'Confirm password']")
	@CacheLookup
	WebElement Confirm_password;
	@FindBy(xpath="//*[text() = '*Password should be at least 8 characters, contain at least one number & one special character.']")
	@CacheLookup
	WebElement PasswordNoteMSG;
	@FindBy(xpath="//*[@value = 'Submit']")
	@CacheLookup
	WebElement SubmitBTN;
	
	@FindBy(xpath="//*[text()= 'Please enter the code']")
	@CacheLookup
	WebElement RPError1;
	
	@FindBy(xpath="//*[text()= 'Please enter a password']")
	@CacheLookup
	WebElement RPError2;
	
	@FindBy(xpath="//*[text()= 'Please enter a Confirmation password']")
	@CacheLookup
	WebElement RPError3;
	
	@FindBy(xpath="//*[@class = 'appHeader_labelForIssue__2_07h'][2]")
	@CacheLookup
	WebElement RPError4;
	
	@FindBy(xpath="//*[text()= 'Code mismatch']")
	@CacheLookup
	WebElement RPError5;
	
	
	@FindBy(xpath="//*[@class = 'swal-title']")
	@CacheLookup
	WebElement Success;
	

	public boolean Text1() {
		return Text1.isDisplayed();
	}
	
	public String Text11() {
		return Text1.getText();
	}
	public boolean Text2() {
		return Text2.isDisplayed();
	}
	public boolean VerificationCode() {
		return VerificationCode.isDisplayed();
	}
	public boolean NewPassword() {
		return NewPassword.isDisplayed();
	}
	public boolean Confirm_password() {
		return Confirm_password.isDisplayed();
	}
	public boolean PasswordNoteMSG() {
		return PasswordNoteMSG.isDisplayed();
	}
	public boolean SubmitBTN() {
		return SubmitBTN.isDisplayed();
	}
	public boolean RPError1() {
		return RPError1.isDisplayed();
	}
	
	public String RPError11() {
		return RPError1.getText();
	}
	
	public String RPError12() {
		return RPError2.getText();
	}
	public String RPError13() {
		return RPError3.getText();
	}
	public String RPError14() {
		return RPError4.getText();
	}
	public String RPError15() {
		return RPError5.getText();
	}
	
	public void EnyterVerificationcode(String VC) {
		VerificationCode.clear();
		VerificationCode.sendKeys(VC);
	}
	
	public void EnyterNewPassword(String NPassword) {
		NewPassword.clear();
		NewPassword.sendKeys(NPassword);
	}
	
	

	public boolean Success() {
		return Success.isDisplayed();
	}
	
	public String successText()
	{
		return Success.getText();
	}

	public void RPSubmitBTN() {
		SubmitBTN.click();
	}

	public void EnterConfirmPassword(String NPassword) {
		Confirm_password.clear();
		Confirm_password.sendKeys(NPassword);
	}
}
