package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.myAccountPage;

public class UserRegWithDDTandExcel extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="ExcelData")
	
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@ Test(priority=1, alwaysRun = true, dataProvider= "ExcelData")
	public void userRegSuccessfully(String fname, String lname , String email , String password) {
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
		registerObject.userLogout();	
	}

}
