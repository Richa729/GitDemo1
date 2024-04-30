package rahulshettyacademy.tests;

import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ViewItemTest extends BaseTest{
	
	String productName ="ZARA COAT 3";
	String countryName ="india";
	@Test
	public void viewItemAddToCart()
	{
	ProductCatalogue productCatalogue=landingPage.loginApplication("richaprakash90@gmail.com", "Test@123");
	productCatalogue.viewItem();
	productCatalogue.goToCart();	
	CartPage cartPage = productCatalogue.goToCart();
	CheckoutPage checkOut=cartPage.goToCheckout();
	checkOut.placeOrder(countryName);
	ConfirmationPage confirm = new ConfirmationPage(driver);
	confirm.getConfirmationMessage();
	}
	
	

}
