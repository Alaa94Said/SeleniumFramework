package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderDetailsPage;
import Pages.productDetailsPage;
import Pages.searchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegPage;

public class RegisteredUserCheckoutProductTest extends TestBase
{
	/*
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to Cart
	 * 4- Checkout
	 * 5- Logout 
	 */

	HomePage homeObject ; 
	UserRegPage registerObject ; 
	LoginPage loginObject ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	searchPage searchObject ; 
	productDetailsPage detailsObject ;
	ShoppingCartPage cartPage ; 
	CheckoutPage checkoutObject ; 
	OrderDetailsPage orderObject ; 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegPage();
		registerObject = new UserRegPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "test852@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
	}

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

	@Test(priority=3)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		detailsObject = new productDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
	}

	@Test(priority=4)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver); 
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	}

	@Test(priority=5)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
