package utils;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import base.Base;



public class Report extends Base  {

	public static ExtentReports report;
	public static ExtentReports reportpage() {
		prop = new Properties();
		if(report == null) {
		
		ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter("./Report.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows 11 Enterprise");
		report.setSystemInfo("browser","chrome");
			
		htmlReporter.config().setDocumentTitle("Automation Results");
		htmlReporter.config().setTimeStampFormat("MM dd yyyy, HH:mm:ss");
		
		
		}
		return report;
	}
	
}
	
	
	
	
	



