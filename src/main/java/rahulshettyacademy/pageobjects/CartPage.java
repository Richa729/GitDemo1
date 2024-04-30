package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitle;
	
	@FindBy(css =".totalRow button")
	WebElement checkout;
	
	public boolean verifyProductDisplay(String productName)
	{
		
		boolean match =productTitle.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public CheckoutPage goToCheckout()
	{
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		checkout.click();
		return checkoutPage;
	}
	
	
	

}
