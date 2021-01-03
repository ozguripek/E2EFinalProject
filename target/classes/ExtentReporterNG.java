package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		//String path= "//Users//imac//Documents//Eclipse-Workspace//E2EProject//reports//index.html";
		String path= "/Users/imac/Documents/Eclipse-Workspace/E2EProject/reports/index.html";
		//String path= System.getProperty("user.dir")+"\\reports\\index.html";
		 ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		 reporter.config().setReportName("Web Automation Results");
		 reporter.config().setDocumentTitle("Test results");
		 
		 extent= new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Özgür Ipek");
		 return extent;
		
		
	}
	

}
