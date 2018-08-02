package test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import data_provider.ConfigProvider;
import factory.AllBrowsers;
import factory.AllObjects;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReports 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports("./Reports/LoginPageReport.html", true);
		logger = new ExtentTest("VerifyLoginPage", "This test case verifies the logout link");
		report.startTest("VerifyLoginPage");
		driver = AllBrowsers.getBrowser("chrome");
		driver.get(AllObjects.getConfigProviderMethods().getApplicationURL());
		logger.log(LogStatus.INFO, "Application is up & running");
	}
	
	@Test
	public void testLoginPage() throws Exception
	{	
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		System.out.println("The Application title is : " + title);		
		Assert.assertTrue(title.contains("Myntra"));
		logger.log(LogStatus.PASS, "Title of the ome page is verified");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginToTheApplication(AllObjects.getDataProviderMethods().getUsername(0, 0, 0),AllObjects.getDataProviderMethods().getPassword(0, 0, 1));
		login.verifyLoginPage();
		System.out.println("User logged into the application successfully.");
		logger.log(LogStatus.PASS, "User logged into the application.");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		AllBrowsers.CloseBrowser();
		report.endTest(logger);
		report.flush();
	}
}
