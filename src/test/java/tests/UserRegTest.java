package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.myAccountPage;

public class UserRegTest extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;

	
	@ Test(priority=1, alwaysRun = true)
	public void userRegSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject= new UserRegPage(driver);
		registerObject.userRegistration("Lilly", "Said", "alaa.abll345@gmail.com", "B@123456");
		//Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}
	@ Test(dependsOnMethods =("userRegSuccessfully"), enabled=false)
	public void registeredUserLogout() {
		registerObject= new UserRegPage(driver);
		registerObject.userLogout();
	}

	@ Test(enabled=false)
	public void registeredUserLogin() {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.userLogin("alaa.abll345@gmail.com", "B@123456");
		registerObject= new UserRegPage(driver);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}


}
