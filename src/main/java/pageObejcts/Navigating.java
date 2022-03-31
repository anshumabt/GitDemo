package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigating {
	public WebDriver driver;
	public Navigating (WebDriver driver)
	{
		  this.driver=driver;	

	}
	private By configurations = By.cssSelector("div[data-cy='Configuration']");
	private By costs = By.cssSelector("a[data-cy='cost-title']");
	private By equipment = By.cssSelector("a[data-cy='Equipment']");
	private By file = By.cssSelector("a[data-cy='File Library']");
	private By issues = By.cssSelector("a[data-cy='Issues']");
	private By personnel = By.cssSelector("a[data-cy='Personnel']");
	private By rooms = By.cssSelector("a[data-cy='Rooms']");
	private By roundsched = By.cssSelector("a[data-cy='Round Schedules']");
	private By sched = By.cssSelector("a[data-cy='Schedules']");
	private By workflows = By.cssSelector("a[data-cy='Workflows']");
	private By operations = By.cssSelector("div[data-cy='Operations']");
	private By guest = By.cssSelector("a[data-cy='Guest Relations']");
	private By serviceorder = By.cssSelector("a[data-cy='Service Orders']");
    
 public WebElement Configurations()
 {
	return driver.findElement(configurations);
 }
 public WebElement Costs()
 {
	return driver.findElement(costs);
 }
 public WebElement Equipments()
 {
	return driver.findElement(equipment);
 }
 public WebElement Issues()
 {
	return driver.findElement(issues);
 }
 public WebElement File()
 {
	return driver.findElement(file);
 }
 public WebElement Rooms()
 {
	return driver.findElement(rooms);
 }
 public WebElement Personnel()
 {
	return driver.findElement(personnel);
 }
 public WebElement RoundSched()
 {
	return driver.findElement(roundsched);
 }
 public WebElement Schedules()
 {
	return driver.findElement(sched);
 }
 public WebElement Workflows()
 {
	return driver.findElement(workflows);
 }
 public WebElement Operations()
 {
	return driver.findElement(operations);
 }
 public WebElement GuestRelations()
 {
	return driver.findElement(guest);
 }
 public WebElement ServiceOrders()
 {
	return driver.findElement(serviceorder);
 }
}