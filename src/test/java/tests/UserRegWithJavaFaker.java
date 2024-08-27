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
import com.github.javafaker.*;

public class UserRegWithJavaFaker extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker(); 
	String Fname = fakeData.name().firstName(); 
	String Lname = fakeData.name().lastName(); 
	String Email = fakeData.internet().emailAddress(); 
	String Password = fakeData.number().digits(8).toString(); 

	
	@ Test(priority=1, alwaysRun = true)
	public void userRegSuccessfully() {
	
		
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject= new UserRegPage(driver);
		registerObject.userRegistration(Fname,Lname,Email,Password);
		System.out.println("the user data is :"+ Fname + " " + Lname + " " + Email + " " + Password);
		//Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.userLogin(Email,Password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();	
	}
	


}
