package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	     @Test(groups= {"ErrorHandling"},retryAnalyzer=rahulshettyacademy.TestComponents.Retry.class)
	    public void loginErrorValidations() {
		String productName ="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("richaprakash90@gmail.com","Test@123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	     
	     }
	     
	   
	   @Test
		public void productErrorValidations(HashMap<String,String> input) throws Exception {
		String productName ="ZARA COAT 3";
		String countryName = "India";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
	
		List<WebElement> products=productCatalogue.getProductsList();
	    productCatalogue.addProductToCart(productName);
	    CartPage cartPage=productCatalogue.goToCart();
		
		boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);;
		
		
		
		
		
	

	   }

}
