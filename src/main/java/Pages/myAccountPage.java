package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends PageBase{

	public myAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.ico-account")
	public WebElement myAccBtn;
	
	@FindBy(linkText ="Change password")
	public WebElement changePWLink;
	
	@FindBy(id ="OldPassword")
	public WebElement oldPWTxt;
	
	@FindBy(id ="NewPassword")
	public WebElement newPWTxt;
	
	@FindBy(id ="ConfirmNewPassword")
	public WebElement confirmNewPWTxt;
	
	@FindBy(css ="button.button-1.change-password-button")
	public WebElement changePWBtn;
	
	@FindBy(css ="p.content")
	public WebElement resultLabel;
	
	public void openChangePasswordLink() {
		clickButton(myAccBtn);
		clickButton(changePWLink);
		
	}
	public void changePassword(String oldPW, String newPW) {
		setTextElementText(oldPWTxt, oldPW);
		setTextElementText(newPWTxt, newPW);
		setTextElementText(confirmNewPWTxt, newPW);
		clickButton(changePWBtn);
	}
}