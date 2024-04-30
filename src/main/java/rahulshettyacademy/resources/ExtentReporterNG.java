package rahulshettyacademy.resources;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public WebDriver driver;
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		//ExtentReports , ExtentSparkReport - responsible for creating reports
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
			    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Richa Prakash");
				return extent;
	}

}
