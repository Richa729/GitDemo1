package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents {
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr th:nth-of-type(3)")
	private List<WebElement> productname;
	
	public boolean verifyOrderDisplayed(String productName) throws Exception
	{
		Thread.sleep(2000);
		
		boolean match=productname.stream().anyMatch(product -> product.getText().equals(productName)); 
		return match;
	}
	

}
