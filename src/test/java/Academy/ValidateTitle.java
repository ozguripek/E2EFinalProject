package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
		log.info("Driver is initialized");
	}
	
	
	@Test
	public void basePageNavigation() throws IOException {
		
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("Navigated to Homepage");
		LandingPage l= new LandingPage(driver);
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Succesfully validated text message");
	}
	
	 @AfterTest 
	  public void teardown() {
		  driver.close();
	  }
	
}
