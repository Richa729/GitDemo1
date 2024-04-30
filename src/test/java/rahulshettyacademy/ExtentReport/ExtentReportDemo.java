package rahulshettyacademy.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	public WebDriver driver;
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		//ExtentReports , ExtentSparkReport - responsible for creating reports
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Richa Prakash");
		
	}
	@Test
	public void initialDemo()
	{
		ExtentTest test =extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		test.fail("Result do not match");
		extent.flush();
	}

}
