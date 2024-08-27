package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.myAccountPage;

public class UserRegWithDDTandJSONFile extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;

	
	@ Test(priority=1, alwaysRun = true)
	public void userRegSuccessfully() throws IOException, ParseException {
		
		JsonDataReader jsonReader = new JsonDataReader(); 
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject= new UserRegPage(driver);
		registerObject.userRegistration(jsonReader.Fname,jsonReader.Lname,jsonReader.Email,jsonReader.Password);
		//Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.userLogin(jsonReader.Email,jsonReader.Password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();	
	}
	


}
