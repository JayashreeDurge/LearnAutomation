package test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data_provider.ConfigProvider;
import factory.AllBrowsers;
import factory.AllObjects;
import pages.HomePage;

public class VerifyHomePage 
{
	WebDriver driver;
	@BeforeMethod
	public void setup() 
	{
		driver = AllBrowsers.getBrowser("chrome");
		driver.get(AllObjects.getConfigProviderMethods().getApplicationURL());
	}
	
	@Test
	public void testHomePage()
	{	
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		System.out.println("The Application title is : " + title);
		
		Assert.assertTrue(title.contains("Myntra"));	
	}
	
	@AfterMethod
	public void tearDown()
	{
		AllBrowsers.CloseBrowser();
	}
}
