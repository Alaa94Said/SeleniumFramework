package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends PageBase{
	
	@FindBy (id = "small-searchterms" )
	WebElement searchTxtBox;

	@FindBy (css = "button.button-1.search-box-button" )
	WebElement searchBtn;
	
	@FindBy (id = "ui-id-1" )
	List<WebElement> productList;
	
	@FindBy (css = "h2.product-title" )
	WebElement productTitle;
	
	public void productSearch(String productName) {
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	
	public void openProductDetailsPage() {
	 clickButton(productTitle);	
	}
	
	public void ProductSearchUsingAutoSuggest(String searchTxT) {
		setTextElementText(searchTxtBox, searchTxT);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();	
		}
	
	public searchPage(WebDriver driver) {
		super(driver);
	}

	
	
	
}
