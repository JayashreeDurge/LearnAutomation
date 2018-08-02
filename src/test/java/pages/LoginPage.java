package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.ExpectedExceptions;

public class LoginPage 
{
	WebDriver driver;
	public void LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	@FindBy (xpath="//div[@class='desktop-userIconsContainer']") WebElement profileIcon;
	@FindBy (xpath="//a[text()='login']") WebElement login;
	@FindBy (xpath="//input[@name='email']") WebElement emailField;
	@FindBy (xpath="//input[@name='password']") WebElement passwordField;
	@FindBy (xpath="//button[@class='login-login-button']")WebElement loginButton;
	@FindBy (xpath="//div[text()=' Logout ']") WebElement logout;
//	@FindBy (xpath="//div[@data-track='logout']") WebElement logout;
	//By logout = By.xpath("//div[text()=' Logout ']");
	//  //div[@data-track='logout']
	public void loginToTheApplication(String username, String password) 
	{
		profileIcon.click();
		login.click();
		emailField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public void verifyLoginPage() throws Exception
	{
		Thread.sleep(5000);
		profileIcon.click();
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(logout));*/
		Thread.sleep(5000);
		String text =  logout.getText();		
		Assert.assertEquals(text, "Logout");
	}
	
}
