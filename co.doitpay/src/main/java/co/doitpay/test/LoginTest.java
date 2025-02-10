package co.doitpay.test;

import co.doitpay.cons.Cons;
import co.doitpay.pom.HomePom;
import co.doitpay.pom.LoginPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest 
{
	
	WebDriver driver = null;

	@BeforeTest
	public void startBrowser()
	{
		try 
		{
		
			System.out.println("Stared");
			 
			 //inisiasi firefox driver path

	        String path = System.getProperty("user.dir");
	        
	        System.out.println(path);

	        System.setProperty("webdriver.firefox.driver",path+ "/gekcodriver");

	        //call firefox driver
	        driver = new FirefoxDriver();
	        
	        // set max window size
	         
	        driver.manage().window().maximize();

	        //call URL on constant file
	        driver.get(Cons.BASE_URL);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
    @org.testng.annotations.Test
    public void testSuccessfulLogin()
    {
    	try
    	{
    		 LoginPom loginPom = new LoginPom(driver);
    	     loginPom.login(Cons.USERNAME, Cons.PASSWORD);

    	     // Assert that the user is on the inventory page (or any other page after successful login)
    	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Cons.TIME_OUT)); 
    	     // Explicit wait
    	     wait.until(ExpectedConditions.urlContains("/inventory.html"));
    	      
    	  // Example assertion
    	     Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html")); 

    	   
    	}
    	
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
       
    }
    
    @Test
    public void testCart()
    {
    	HomePom homePom =  new HomePom(driver);
    	
    	homePom.addToCart();
    }

    
    @AfterTest
    public void stop()
    {
    	//driver.quit();
    }
   

   
}