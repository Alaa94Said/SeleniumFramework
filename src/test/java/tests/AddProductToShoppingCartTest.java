package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import Pages.ShoppingCartPage;
import Pages.HomePage;
import Pages.productDetailsPage;
import Pages.searchPage;

public class AddProductToShoppingCartTest extends TestBase 
{
	searchPage searchPage;
	productDetailsPage productDetails;
	ShoppingCartPage cartPage ; 
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new searchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new productDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productDetails = new productDetailsPage(driver);
		productDetails.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		cartPage = new ShoppingCartPage(driver); 
		cartPage.RemoveProductFromCart();
	}
}
