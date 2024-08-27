package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.productDetailsPage;
import Pages.searchPage;

public class ChangeCurrencyTest extends TestBase
{
	HomePage homeObject ; 
	searchPage searchObject;
	productDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch"; 
	

	@Test(priority=1)
	public void UserCanCanChangeCurrency() 
	{
		homeObject = new HomePage(driver); 
		homeObject.changeCurrency();
	}
	
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new searchPage(driver); 
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new productDetailsPage(driver); 
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productPricelbl.getText().contains("€"));
			System.out.println(detailsObject.productPricelbl.getText());
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
	
	
}
