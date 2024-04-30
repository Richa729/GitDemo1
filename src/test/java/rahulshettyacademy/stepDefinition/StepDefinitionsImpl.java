package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionsImpl extends BaseTest{
	
	public LandingPage landinPage;
	public ProductCatalogue productCatalogue;
	public CheckoutPage checkoutPage;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage;
	@Given ("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landinPage=launchApplication();
		
	}
	
	 @Given ("^Logged in with username(.+) and password(.+)$")
	 public void Logged_in_with_username_and_password(String username, String password)
	 {
		 productCatalogue= landinPage.loginApplication(username,password);
	 }
	 
	 @When ("^I add product(.+)from cart$")
	 public void i_add_product_from_cart(String productName) throws Exception
	 {
		 
		 List<WebElement> products=productCatalogue.getProductsList();
		    productCatalogue.addProductToCart(productName);
	 }
	 @And ("^Checkout(.+)and submit the order$")
	 public void checkout_and_submit_the_order(String productName)
	 {
		 productCatalogue.goToCart();
		 boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkoutPage = cartPage.goToCheckout(); 
	 }
	  @Then ("^Confirmation(.+) message is displayed$")
	  public void Confirmation_message_is_displayed(String confirmation)
	  {
		 checkoutPage.placeOrder("india");
		 String confirmationMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(confirmation));
	  }
	 
	

}
