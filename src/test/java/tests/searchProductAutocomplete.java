package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productDetailsPage;
import Pages.searchPage;

public class searchProductAutocomplete extends TestBase {
String productName = "Apple MacBook Pro 13-inch";
	searchPage searchObject;
	productDetailsPage detailsObject;
	
	@Test
	public void userSearchProductAutoSuggest() {
		try {
			searchObject = new searchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			
			detailsObject= new productDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("Error occured  "+ e.getMessage());
		}
		
	}
}
