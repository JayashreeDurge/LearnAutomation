package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
 public HomePage(WebDriver ldriver)
 {
	this.driver = ldriver;
 }

 @FindBy(xpath="//span[text()='Your Orders'][@class='nav-line-2']") WebElement SignIn;
 @FindBy(xpath="//a[@id='nav-link-prime']") WebElement TryPrime;
 @FindBy(xpath="//span[@class='nav-line-2'][text()='Lists']") WebElement YourList;
 
 public void clickOnSignInLink() 
 {
	 SignIn.click();
 }
 
 public void clickOnTryPrime() 
 {
	 TryPrime.click();
 }
 
 public  void ClickOnYourList() 
 {
	 YourList.click();
 }
 
 public String getApplicationTitle()
 {
	return driver.getTitle();
 }
}
