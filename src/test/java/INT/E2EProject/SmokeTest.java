package INT.E2EProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObejcts.LandingPage;
import pageObejcts.Navigating;
import pageObejcts.Socreation;
import resources.Base;

public class SmokeTest extends Base{
	public WebDriver driver;
	public LandingPage sg;
	public Navigating ng;
	public Socreation soc;
	public Actions a;
	Logger logger = (Logger) LogManager.getLogger(SmokeTest.class);
	
	@BeforeClass
	public void setUp() throws IOException {
	  driver = initializeDriver();
	  driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();
	  sg = new LandingPage(driver);
	  ng = new Navigating(driver);
	  soc = new Socreation(driver);
	  a = new Actions(driver);
	}
     @Test(priority=1, dataProvider="getData")
    public void SignIn(String username, String password, String text)
     {
         sg.Username().sendKeys(username);
         sg.pwd().sendKeys(password);
         sg.Login().click();
         System.out.println(text +" "+driver.getTitle());
     }
     
     @DataProvider
     public Object[][] getData()
     {
    	 //Rows stands for how many different data types test should run
    	 //Columns stands for how many value each test
    	 Object[][] data = new Object[1][3];
    	 data[0][0]="anshuma-int";
    	 data[0][1]="password@00";
         data[0][2]="Correct user is loged in";
    	 
    	 /*data[1][0]="anshuma-asp";
    	 data[1][1]="password@00";
    	 data[1][2]="Correct ASP user is loged in";*/
    	 
    	 return data;
     }
     
    @AfterTest
     public void DriverQuit() throws IOException
     {
    	driver.manage().deleteAllCookies();
    	driver.quit();
     }
    @Test(priority=2)
     public void Navigation() throws IOException 
     {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
    	 ng.Configurations().click();
    	 ng.Costs().click();
    	 System.out.println(ng.Costs().getText());
    	 Assert.assertEquals(ng.Costs().getText(), "Costs");
    	 ng.Equipments().click();
    	 System.out.println(ng.Equipments().getText());
    	 Assert.assertEquals(ng.Equipments().getText(), "Equipment");
    	 ng.File().click();
    	 System.out.println(ng.File().getText());
    	 Assert.assertEquals(ng.File().getText(), "File Library");
    	 ng.Issues().click();
    	 System.out.println(ng.Issues().getText());
    	 Assert.assertEquals(ng.Issues().getText(), "Issues");
    	 ng.Rooms().click();
    	 System.out.println(ng.Rooms().getText());
    	 Assert.assertEquals(ng.Rooms().getText(), "Rooms");
    	 ng.RoundSched().click();
    	 System.out.println(ng.RoundSched().getText());
    	 Assert.assertEquals(ng.RoundSched().getText(), "Round Schedules");
    	 ng.Schedules().click();
    	 System.out.println(ng.Schedules().getText());
    	 Assert.assertEquals(ng.Schedules().getText(), "Schedules");
    	 ng.Personnel().click();
    	 System.out.println(ng.Personnel().getText());
    	 Assert.assertEquals(ng.Personnel().getText(), "Personnel");
    	 ng.Workflows().click();
    	 System.out.println(ng.Workflows().getText());
    	 Assert.assertEquals(ng.Workflows().getText(), "Workflows");
    	 ng.Operations().click();
    	 ng.Operations().click();
    	 ng.GuestRelations().click();
    	 System.out.println(ng.GuestRelations().getText());
    	 Assert.assertEquals(ng.GuestRelations().getText(), "Guest Relations");
    	 ng.ServiceOrders().click();
    	 System.out.println(ng.ServiceOrders().getText());
    	 Assert.assertEquals(ng.ServiceOrders().getText(), "Service Orders");
    	 Assert.assertTrue(soc.FAB().isDisplayed());
    	 System.out.println("****Test completed****");
     }
    
    @Test(priority=3)
     public void SOCreation() throws IOException, InterruptedException
     { 
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100)); 
    	 soc.AllOrders().click();
    	 soc.FAB().click();
    	 soc.Create().click();
    	 soc.RoomEq().click();
    	 soc.SelectLocation().click();
 		/*iterate the options to get exact match
 		for(WebElement option :options1)
 		{
 		if(option.getText().equalsIgnoreCase("Smoke"))
 		{
 			option.click();
 			break;
 		}
 		}*/
    	 soc.NextArrow().click();
    	 Thread.sleep(5000);
    	 soc.SelectIssue().click();
    	 Thread.sleep(5000);
    	 soc.NextArrow().click();
    	 Thread.sleep(5000);
    	 System.out.println("Location name from SO creation: " + soc.LocName().getText());
    	 String ln=soc.LocName().getText();
    	 soc.Save().click();
    	 //soc.Refresh().click();
    	 a.moveToElement(soc.Age()).doubleClick().build().perform();
    	 Thread.sleep(5000);
    	 System.out.println("Location name from SO list: " + soc.LocName1().getText());
    	 String ln1 = soc.LocName1().getText();
    	 Assert.assertEquals(ln,  ln1);
    	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 FileUtils.copyFile(src, new File("C:\\Users\\Anshuma\\Screenshot\\screenshot.png"));
    	 System.out.println("****SO Test completed****");
     }
    
    @Test(priority=4)
    public void logs()
    {
    	System.out.println("****Logs data****");
    	logger.info("********Logger message********");
    	logger.fatal("*******Fatal message********");
    	logger.error("********Error message********");
    	logger.debug("********Debug message********");
    }
}
