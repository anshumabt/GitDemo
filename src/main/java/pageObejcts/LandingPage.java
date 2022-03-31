package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	public WebDriver driver;
	public LandingPage (WebDriver driver)
	{
		  this.driver=driver;
		  
	}
	private By username = By.xpath("//input[@placeholder = 'Username']");
	/*@FindBy (xpath= "//input[@placeholder = 'Username']")
	WebElement username;*/
	private By password = By.xpath("//input[@placeholder = 'Password']");
	private By loginBtn = By.xpath("//button[contains(text(), 'LOGIN')]");
    
 public WebElement Username()
 {
	return driver.findElement(username);
 }
 public WebElement pwd()
 {
	return driver.findElement(password);
 }
 public WebElement Login()
 {
	return driver.findElement(loginBtn);
 }
}