package INT.E2EProject;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObejcts.Costs;
import pageObejcts.LandingPage;
import pageObejcts.Navigating;
import pageObejcts.Socreation;
import resources.Base;

public class CostsTest  extends Base{
	public WebDriver driver;
	public LandingPage sg;
	public Navigating ng;
	public Socreation soc;
	public Costs co;
	public Random r;
	Logger logger = (Logger) LogManager.getLogger(SmokeTest.class);
	
	@BeforeClass
	public void setUp() throws IOException
    {
	  driver = initializeDriver();
	  driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();
	  sg = new LandingPage(driver);
	  ng = new Navigating(driver);
	  soc = new Socreation(driver);
	  co = new Costs(driver);
	  r = new Random();
	}
	
	@Test(priority=1, dataProvider="getData")
    public void SignIn(String username, String password, String text)
     {
         sg.Username().sendKeys(username);
         sg.pwd().sendKeys(password);
         sg.Login().click();
         System.out.println(text +" "+driver.getTitle());
         logger.info("Logged in successfully");
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
    public void create() throws InterruptedException
    {
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 
   	 ng.Configurations().click();
   	 ng.Costs().click();
   	 co.CostCodeTab();
   	 Thread.sleep(5000);
   	 System.out.println(co.ShowingCount().getText());
   	 String count = co.ShowingCount().getText().replaceAll("\\s+","").split("Showing")[1].split("items")[0];
   	 System.out.println(count);
   	 int i=Integer.parseInt(count);  
   	 soc.FAB().click();
   	 co.CostName().sendKeys("Test-CostName" + r.nextInt());
   	 co.CostCode().sendKeys("Test-Cost Code" + r.nextInt());
   	 soc.Save();
   	 int i1 = i+1;
   	System.out.println(i);
  	 System.out.println(i1);
   	if (i1 < i)
   	{
   		System.out.println("New Cost Code is added");
   		logger.info("New Cost Code is added");
   	}
   	else
   	{
   		System.out.println("New Cost Code is not added");
   		logger.info("New Cost Code is not added");
   	}
   	
    }
}
