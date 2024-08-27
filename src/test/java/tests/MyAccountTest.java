package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.myAccountPage;


public class MyAccountTest extends TestBase{
	myAccountPage myAccObject;
	HomePage homeObject;
	UserRegPage registerObject;
	LoginPage loginObject;
	String oldPW="d@1234";
	String newPW="d@123456";
	String firstName= "Lilly";
	String lastName = "Said";
	String email= "alaa.abllel5y768@gmail.com";
	@ Test(priority=1)
	public void userRegSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject= new UserRegPage(driver);
		registerObject.userRegistration(firstName, lastName , email, oldPW);
		//Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}
	
	@ Test(dependsOnMethods = "userRegSuccessfully")
	public void registeredUserCanChangePassword() throws InterruptedException {
		myAccObject = new myAccountPage(driver); // creating object
		myAccObject.openChangePasswordLink();
		myAccObject.changePassword(oldPW, newPW);
		Assert.assertTrue(myAccObject.resultLabel.getText().contains("Password was changed"));
		driver.findElement(By.cssSelector("span.close")).click();
		Thread.sleep(200);
	}
	
	@ Test(dependsOnMethods = "registeredUserCanChangePassword")
	public void registeredUserLogout() {
		
		registerObject.userLogout();
	}
	
	@ Test(dependsOnMethods = "registeredUserLogout")
	public void registeredUserLogin() {
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.userLogin(email ,newPW );
		System.out.println("i'm out succefuly");
		//registerObject= new UserRegPage(driver);
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
