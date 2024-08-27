package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.myAccountPage;

public class UserRegWithDDTandPropertiesFile extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;
	String fname = LoadProperties.userData.getProperty("firstname");
	String lname = LoadProperties.userData.getProperty("lastname"); 
	String email = LoadProperties.userData.getProperty("email"); 
	String Password = LoadProperties.userData.getProperty("password"); 
	
	
	@ Test(priority=1, alwaysRun = true)
	public void userRegSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject= new UserRegPage(driver);
		registerObject.userRegistration(fname,lname,email,Password);
		//Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.userLogin(email, Password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();	
	}


}
