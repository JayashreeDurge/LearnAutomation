package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllBrowsers 
{
	static WebDriver driver;
	public static WebDriver getBrowser(String browser_name) 
	{
		if (browser_name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", AllObjects.getConfigProviderMethods().getChromePath());
			driver = new ChromeDriver();
		}
		else if (browser_name.equalsIgnoreCase("firefox")) 
		{
			System.out.println("Ignore Firefox as of now.");
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void CloseBrowser()
	{
		driver.close();
	}

}
