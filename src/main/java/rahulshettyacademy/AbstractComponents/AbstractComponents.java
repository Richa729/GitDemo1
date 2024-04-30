package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrdersPage;

public class AbstractComponents {
	
    
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css ="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;

	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement ordersHeader;
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		}
		
	public CartPage goToCart()
	{
		CartPage cartPage=new CartPage(driver);
		cartHeader.click();
		return cartPage;
	}

	public void waitForElementToDisappear(WebElement ele) throws Exception {
		
	    Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	public void actionOnSelect(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
	}

	public OrdersPage goToOrdersPage()
	{
		
		ordersHeader.click();
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;
				
	}
}
