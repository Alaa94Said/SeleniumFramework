package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.myAccountPage;

public class UserRegWithDDTandDataProvider extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;

	
	@DataProvider(name="testData")
	
	public static Object[][] userData()  // static array
	{
		return new Object[][] {
			{"Lilly","Said","alaa3@gmail.com","123456"}
		,{"Ahmed","Ali","testuserrr1270073@gmail.com","12345678"}};
		
	}
	
	@ Test(priority=1, alwaysRun = true, dataProvider= "testData")
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
	@ Test(priority=2, dependsOnMethods =("userRegSuccessfully"), enabled=false)
	public void registeredUserLogout() {
		registerObject= new UserRegPage(driver);
		registerObject.userLogout();
	}

	@ Test(priority=3 , enabled=false)
	public void registeredUserLogin(String email,String password) {
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.userLogin(email,password);
		registerObject= new UserRegPage(driver);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}


}
