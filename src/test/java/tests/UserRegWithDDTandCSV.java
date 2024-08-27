package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;

import com.opencsv.CSVReader;


public class UserRegWithDDTandCSV extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader ; 
	
	@ Test(priority=1, alwaysRun = true)
	public void userRegSuccessfully() throws IOException {
		
		// get path of CSV file 
				String CSV_file = "D:\\Prog\\Eclips projects\\TAF\\src\\test\\java\\Data\\userData.csv";
				reader = new CSVReader(new FileReader(CSV_file)); 
				
				String[] csvCell ; 

				// while loop will be executed till the lastvalue in CSV file . 
				while((csvCell = reader.readNext()) != null) 
				{
					String fname = csvCell[0]; 
					String lname = csvCell[1]; 
					String email = csvCell[2]; 
					String password = csvCell[3]; 
				
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject= new UserRegPage(driver);
		registerObject.userRegistration(fname,lname,email,password);
		//Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();}	
	}

	}
