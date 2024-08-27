package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegPage extends PageBase{
	
	//lazm ykon fe constructor 3shan inherted mn class feh constructor
	public UserRegPage(WebDriver driver) {
		super(driver);// bec it's inherted
	}
	
	@FindBy(id="gender-female")
	WebElement genderRadioBtn;
	  
	@FindBy(id="FirstName")
	WebElement firstNameTxt;

	@FindBy(id="LastName")
	WebElement lastNameTxt;
	
	@FindBy(id="Email")
	WebElement emailTxt;
	
	@FindBy(id="Password")
	WebElement passwordTxt;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css ="a.ico-logout")
	public WebElement logoutLink;
	
	@FindBy(linkText ="Log in")
	public WebElement loginLink;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(linkText ="My account")
	public WebElement myAccountLink;
	
	@FindBy(css="div.result")   // tag+class name
	public WebElement successmessage;
	
	public void userRegistration(String firstname, String lastname, String email, String password) {
		clickButton(genderRadioBtn);  //genderRadioBtn.click();
		setTextElementText(firstNameTxt,firstname);//firstNameTxt.sendKeys(firstname);
		setTextElementText(lastNameTxt,lastname);   //lastNameTxt.sendKeys(lastname);
		setTextElementText(emailTxt,email);   //emailTxt.sendKeys(email);
		setTextElementText(passwordTxt,password);   //passwordTxt.sendKeys(password);
		setTextElementText(confirmPasswordTxt,password);    //confirmPasswordTxt.sendKeys(password);
		clickButton(registerBtn);  //registerBtn.click();
	}
	public void userLogout() {
		clickButton(logoutLink);
		
	}
	public void openMyAccount() {
		clickButton(myAccountLink);
		
	}
}
