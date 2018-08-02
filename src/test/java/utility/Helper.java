package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	public static String CaptureScreenshot(WebDriver driver, String ScreeenshotName)
	{
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 
		 String destination = "C:\\Users\\jayashree\\eclipse-workspace\\com.myproject.framework\\Screenshots\\"+ScreeenshotName+System.currentTimeMillis()+".png";
		 
		 try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e)
		 {
			System.out.println("Failed to capture screenshot"+e.getMessage());
		}
		 return destination;
	}
}
