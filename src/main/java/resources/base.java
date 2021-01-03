package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		//FileInputStream fis = new FileInputStream("/Users/imac/Documents/Eclipse-Workspace/E2EProject/src/main/java/resources/data.properties");
		//FileInputStream fis = new FileInputStream("//Users//imac//Documents//Eclipse-Workspace//E2EProject//src//main//java//resources//data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
		
		prop.load(fis);
		String browserName= System.getProperty("browser");
		//String browserName = prop.getProperty("browser");

		/*if (browserName.equals("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "//Users//imac//Documents//Chrome-Driver//chromedriver");
			System.setProperty("webdriver.chrome.driver", "/Users/imac/Documents/Chrome-Driver/chromedriver");
			driver = new ChromeDriver();
		}*/
		
		
		
		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/imac/Documents/Chrome-Driver/chromedriver");
			
			ChromeOptions options= new ChromeOptions();
			
			if(browserName.contains("headless")) {
				options.addArguments("headless");	
			}
			
			driver = new ChromeDriver(options);

			//System.setProperty("webdriver.chrome.driver", "//Users//imac//Documents//Chrome-Driver//chromedriver");
			
			//driver = new ChromeDriver();
		}
		

		else if (browserName.equals("firefox")) {

			// System.setProperty("webdriver.firefox.driver","//Users//imac//Documents//Firefox-Driver//Firefoxriver");
			//driver = new FireFoxDriver();
		}

		else if (browserName.equals("IE")) {

			// System.setProperty("webdriver.ie.driver", "//Users//imac//Documents//IE-Driver//IEdriver");
			//driver = new IEDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		//String destinationFile= System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		String destinationFile="/Users/imac/Documents/Eclipse-Workspace/E2EProject/reports/"+testCaseName+".png";
		//String destinationFile="//imac//Documents//Eclipse-Workspace//E2EProject//reports//"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
