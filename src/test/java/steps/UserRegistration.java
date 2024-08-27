package steps;

import org.testng.Assert;

import Pages.HomePage;
import Pages.UserRegPage;
import tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration extends TestBase{

	HomePage homeObject;
	UserRegPage registerObject;

@Given("the user in the home page")
public void the_user_in_the_home_page() {
	homeObject= new HomePage(driver);
	homeObject.openRegPage();
}
@When("I click on register link")
public void i_click_on_register_link() {
	Assert.assertTrue(driver.getCurrentUrl().contains("register"));
}
/*
 * @When("I entered the user data") public void i_entered_the_user_data() {
 * registerObject = new UserRegPage(driver);
 * registerObject.userRegistration("Moaa", "Nghmxvil", "motgxfvdz@test.com",
 * "12345678"); }
 */

@When("I enter {string} {string} {string} {string}")
public void i_enter(String firstname, String lastname,String email,String password) {
	registerObject = new UserRegPage(driver); 
	registerObject.userRegistration(firstname, lastname,email,password);
	
}

@Then("the registraion page displayed succefully")
public void the_registraion_page_displayed_succefully() {
	registerObject.userLogout();
}

}
