package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Report;

public class Base {

	public static WebDriver driver;
	public static Properties prop;


	public ExtentReports report= Report.reportpage();
	public ExtentTest logger;



	@BeforeMethod
	public void browser() {
		prop = new Properties();
		logger = report.createTest("opening browser");
		try {
			prop.load(new FileInputStream("src/main/java/config/config.properties"));

		}
		catch (Exception e) {
			e.printStackTrace();
		}


		if(prop.getProperty("browserName").matches("chrome")) {
			//opening chrome browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		if(prop.getProperty("browserName").matches("edge")) {
			//opening edge browser
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		logger.info("opening "+prop.getProperty("browserName")+" browser");
		//maximizing browser window
		driver.manage().window().maximize();



	}
	@BeforeMethod
	public void openWebsite() {
		//creating test report
		logger = report.createTest("Opening Url");
		logger.info("opening "+prop.getProperty("browserName"));
		try{
			driver.get(prop.getProperty("url"));
			//executing pass report
			testPass("url launched successfully");
		}
		catch (Exception e) {
			//executing fail report
			testFail(e.getMessage());
		}
		logger.info(prop.getProperty("url"));

	}
	public void testPass(String report) {
		logger.log(Status.PASS, report);
	}

	public void testFail(String report) {
		logger.log(Status.FAIL, report);
		failScreenShot();
	}

	public void failScreenShot()  {
		try{
			File fscr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//taking failed screenshot 
			String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			Files.copy(fscr, new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\failscreenshot\\"+timeStamp+".jpg"));
			logger.addScreenCaptureFromPath("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\failscreenshot\\"+timeStamp+".jpg");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@AfterMethod
	public void closeBrowser() {
		logger = report.createTest("closing "+prop.getProperty("browserName")+ " browser");
		//closing browser
		driver.close();

	}
	@AfterSuite
	public void endReport() {
		//report close
		report.flush();
	}

	public static XSSFSheet excel() throws IOException {
		//Locate The File
		String filelocation = "C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\src\\resource\\userdata.xlsx";
		@SuppressWarnings("resource")
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);		
		XSSFSheet sheet = wbook.getSheetAt(0);
		return sheet;
	}


}

