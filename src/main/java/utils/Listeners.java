package utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;
	
public class Listeners extends Base implements ITestListener {
	static Logger logg = Logger.getLogger(Listeners.class);
	public static void PropertyConfigurator() {
		PropertyConfigurator.configure("Logger.properties");
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test case is going to execute");
		logg.info("Test case is going to execute");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed successfully");
		logg.info("Test case passed successfully");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed");
		logg.info("Test case failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped");
		logg.info("Test case skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("test case passed with some fail");
		logg.info("test case passed with some fail");
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Launching program");
		logg.info("Launching program");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Closing program");
		logg.info("Closing program");
	}
}
