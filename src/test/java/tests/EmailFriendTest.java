package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegPage;
import Pages.productDetailsPage;
import Pages.searchPage;

public class EmailFriendTest extends TestBase{

	
	HomePage homeObject ; 
	UserRegPage registerObject ; 
	LoginPage loginObject ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	searchPage searchObject ; 
	productDetailsPage detailsObject ;
	EmailPage emailObject ; 

	// 1- User Registration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegPage();
		registerObject = new UserRegPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "test7486@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}
	
	// 2- Search For Product
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new searchPage(driver); 
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new productDetailsPage(driver); 
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
	
	// 3- Email to Friend
	@Test(priority=3)
	public void RegisteredUserCanSendProductToFriend() 
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver); 
		emailObject.SendEmailToFriend("aaa1@tte.com", "Hello my friend , check this product");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}
	
	// 4- User Lgoout
	@Test(priority=4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
