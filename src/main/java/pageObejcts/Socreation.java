package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Socreation {
	public WebDriver driver;
	public Socreation (WebDriver driver)
	{
		  this.driver=driver;	
	}
	private By allorders = By.xpath("//span[contains(text(), \"All Orders\")]");
	private  By fab = By.cssSelector("button[ng-reflect-message=\"Create\"]");
	private  By create= By.xpath("//table//tr[3]//td[2]//button");
	private By roomeq = By.xpath("//input[@data-placeholder = \"Room/Equipment\"]");
	private By list = By.cssSelector("div[role=\"listbox\"]");
	private By selectlocation = By.xpath("//mat-option[1]");
	private By nextarrow = By.cssSelector("button[ng-reflect-message=\"Next\"]");
	private By selectissue = By.xpath("//virtual-scroller/div/div[1]/div//button");
	private By locname= By.xpath("//span[text()= \"**3.101 Room 331\"]");
	private By save = By.cssSelector("button[ng-reflect-message='Save']");
	private By refresh = By.cssSelector("button[ng-reflect-message='Refresh']");
	private By age = By.xpath("//div[text()='Age']");
	private By locname1 = By.xpath("//tr[@aria-rowindex='1']/td[@aria-colindex='10']");
   
 public WebElement AllOrders()
 {
	return driver.findElement(allorders);
 }
 public WebElement FAB()
 {
	return driver.findElement(fab);
 }
 public WebElement Create()
 {
	return driver.findElement(create);
 }
 public WebElement RoomEq()
 {
	return driver.findElement(roomeq);
 }
 public WebElement SelectLocation()
 {
	return driver.findElement(selectlocation);
 }
 public WebElement NextArrow()
 {
	return driver.findElement(nextarrow);
 }
 public WebElement SelectIssue()
 {
	return driver.findElement(selectissue);
 }
 public WebElement Save()
 {
	return driver.findElement(save);
 }
 public WebElement Refresh()
 {
	return driver.findElement(refresh);
 }
 public WebElement Age()
 {
	return driver.findElement(age);
 }
 public WebElement LocName()
 {
	return driver.findElement(locname);
 }public WebElement LocName1()
 {
	return driver.findElement(locname1);
 }
}