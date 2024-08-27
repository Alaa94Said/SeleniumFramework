package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.WishlistPage;

import Pages.HomePage;
import Pages.productDetailsPage;
import Pages.searchPage;

public class AddProductToWishListTest extends TestBase
{
	searchPage searchPage;
	productDetailsPage productDetails;
	WishlistPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new searchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new productDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToWishlist() throws InterruptedException {
		productDetails = new productDetailsPage(driver);
		productDetails.AddProductToWishlist();
		driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
		wishlistObject = new WishlistPage(driver); 
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject = new WishlistPage(driver); 
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.EmptyCartLbl.getText().contains("The wishlist is empty!"));
	}

}
