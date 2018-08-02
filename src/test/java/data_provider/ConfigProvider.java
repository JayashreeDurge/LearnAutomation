package data_provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigProvider 
{
	Properties prop;
	public ConfigProvider()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() 
	{
		String url = prop.getProperty("URL");
		return url;
	}
	
	public String getChromePath() 
	{
		String chromeDriver = prop.getProperty("ChromeDriver");
		return chromeDriver;
	}
}
