package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.productDetailsPage;
import Pages.searchPage;

public class AddProductToCompareTest extends TestBase
{
    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop"; 

	// 1- Search for product number 1
	// 2- Search for product number 2 
	// 3- Add to compare 
	// 4- Clear list

	productDetailsPage detailsObject ; 
	HomePage homeObject ; 
	ComparePage compareObject ; 
	searchPage searchObject ; 

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException {
		searchObject = new searchPage(driver);
		detailsObject = new productDetailsPage(driver);
		compareObject = new ComparePage(driver);

		searchObject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();

		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompare();
		Thread.sleep(1000);

		driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(compareObject.secodProductName.getText().equals("Apple MacBook Pro 13-inch"));
		compareObject.CompareProducts();	
	}

	@Test(priority=2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
