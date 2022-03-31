package pageObejcts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Costs {
	public WebDriver driver;
	public Costs (WebDriver driver)
	{
		  this.driver=driver;	
	}
	
	private By costcodetab = By.xpath("//li[@data-cy=\"cost-cost-code-tab\"]");
	private By costname= By.xpath("//input[@name=\"codeName\"]");
	private By costcode = By.xpath("//input[@name=\"code\"]");
	private By showingcount = By.cssSelector("div.app-grid-info-footer-container span");
	
	
	public WebElement CostName()
	 {
		return driver.findElement(costname);
	 }
	public WebElement CostCode()
	 {
		return driver.findElement(costcode);
	 }
	public WebElement ShowingCount()
	 {
		return driver.findElement(showingcount);
	 }
	public WebElement CostCodeTab()
	 {
		return driver.findElement(costcodetab);
	 }
}
