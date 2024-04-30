package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	
		// TODO Auto-generated method stub
	      String productName ="ZARA COAT 3";
		@Test(dataProvider="getData",groups= {"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws Exception {
		
		String countryName = "India";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
	
		List<WebElement> products=productCatalogue.getProductsList();
	    productCatalogue.addProductToCart(input.get("productName"));
	    CartPage cartPage=productCatalogue.goToCart();
		
		boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		ConfirmationPage confirmationPage=checkoutPage.placeOrder(countryName);
		String confirmationMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		}
		
		//To verify that ZARA COAT 3 is displaying in orders page
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void orderHistoryTest(HashMap<String,String> input) throws Exception
		{
			ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
			OrdersPage orderPage=productCatalogue.goToOrdersPage();
			Assert.assertTrue(orderPage.verifyOrderDisplayed(productName));
			
		}	
		@DataProvider
		public Object[][] getData() throws IOException
		{
//			HashMap<String,String> map = new HashMap<String,String>();
//			map.put("email", "richaprakash90@gmail.com");
//			map.put("password", "Test@123");
//			map.put("productName", "ZARA COAT 3");
//			
//			HashMap<String,String> map1 = new HashMap<String,String>();
//			map1.put("email", "priya17@gmail.com");
//			map1.put("password", "Test@123");
//			map1.put("productName", "ADIDAS ORIGINAL");
//			
			List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
			
		     return new Object[][] {{data.get(0)},{data.get(1)}};
		}
}
