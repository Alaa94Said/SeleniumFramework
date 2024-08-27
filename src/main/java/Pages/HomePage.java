package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	


	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		
	}
@FindBy(linkText="Register")
	WebElement registerLink;

@FindBy(css="a.ico-login")
WebElement LoginLink;

@FindBy(linkText="Contact us")
WebElement contactUsLink ;

@FindBy(id="customerCurrency")
WebElement currencydrl; 

@FindBy(linkText="Computers")
WebElement ComputerMenu; 

@FindBy(linkText="Notebooks")
WebElement NotbooksMenu; 

public void openRegPage() {
	clickButton(registerLink); //cause we created method in pageBase
	
	//registerLink.click();
}

public void openLoginPage() {
	clickButton(LoginLink); //cause we created method in pageBase
	
}


public void openContactUsPage() {
	clickButton(contactUsLink); //cause we created method in pageBase
	
}

public void selectNotebooksMenu() 
	{
	Actions action = new Actions(driver); 
		action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
	}

public void changeCurrency() 
	{
		select = new Select(currencydrl); 
		select.selectByVisibleText("Euro");
	}
}
