package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement result1;
	
	@FindBy(css=".action__submit")
	WebElement proceed;

	By result = By.cssSelector(".ta-results");
	
	public ConfirmationPage placeOrder(String countryName)
	{
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		actionOnSelect(countryName);
		waitForElementToAppear(result);
		result1.click();
		proceed.click();
		return confirmationPage;
	
	}
	
	

}
