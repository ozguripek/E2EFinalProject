package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
		log.info("Driver is initialized");
	}
		
	@Test
  public void basePageNavigation() throws IOException  {
	
	  String url= prop.getProperty("url");
	  driver.get(url);
	  log.info("Navigated to Homepage");
	  LandingPage l= new LandingPage(driver);
	  AssertJUnit.assertTrue(l.getNavigationBar().isDisplayed());
	  log.info("Succesfully validated title");
	  //AssertJUnit.assertFalse(l.getNavigationBar().isDisplayed());	  
  }
  
  @AfterTest 
  public void teardown() {
	  driver.close();
  }
}
