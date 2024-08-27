package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productDetailsPage;
import Pages.searchPage;

public class searchProductTest extends TestBase{
	
	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObject;
	productDetailsPage detailsObject;
	
	@Test
	public void userSearchProduct() {
		searchObject = new searchPage(driver);
		detailsObject = new productDetailsPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		//Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}

}
