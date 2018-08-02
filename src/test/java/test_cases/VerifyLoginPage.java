package test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data_provider.ConfigProvider;
import factory.AllBrowsers;
import factory.AllObjects;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage 
{
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		driver = AllBrowsers.getBrowser("chrome");
		driver.get(AllObjects.getConfigProviderMethods().getApplicationURL());
	}
	
	@Test
	public void testLoginPage() throws Exception
	{	
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		System.out.println("The Application title is : " + title);		
		Assert.assertTrue(title.contains("Myntra"));
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginToTheApplication(AllObjects.getDataProviderMethods().getUsername(0, 0, 0),AllObjects.getDataProviderMethods().getPassword(0, 0, 1));
		login.verifyLoginPage();
		System.out.println("User logged into the application successfully.");
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		AllBrowsers.CloseBrowser();
	}
}
