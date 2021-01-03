package Academy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
		log.info("Driver is initialized");
	}	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException{
		
		
		String url = prop.getProperty("url");
		driver.get(url);	
		log.info("Navigated to Homepage");
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(Username);		
		lp.getPassword().sendKeys(Password);
		System.out.println(text);
		log.info(text);
		lp.getLogin().click();		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data= new Object[2][3];
		data[0][0]= "özgüripekr@qw.com";
		data[0][1]= "1234"	;	
		data[0][2]= "kayitli kullanici";
				
		data[1][0]= "muhammet@qw.com";
		data[1][1]= "1234";		
		data[1][2]= "kayitli olamayan kullanici";		
		
		return data;
	}
	
	 @AfterTest 
	  public void teardown() {
		  driver.close();
	  }

}
