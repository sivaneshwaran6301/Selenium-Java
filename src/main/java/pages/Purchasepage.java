package pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import base.Base;

public class Purchasepage extends Base {


	By search = By.id("search_query_top");
	By addtocart = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]");
	By proceed = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	By summary = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");


	public void search(String schpg ,String model) throws IOException {

		logger = report.createTest("search page");

		try {		
			//Searching Product
			driver.findElement(search).sendKeys(model);
			logger.info("searching "+model);
			//taking screenshot for searchpage
			File searchPg=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(searchPg, new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\search page.jpg"));

			//Clicking Search Button
			driver.findElement(search).submit();
			String sch = driver.findElement(By.className("lighter")).getText();

			if(sch.equals(schpg)) {
				testPass("search page verified");	}
			else {
				testFail("test fail due to invalid asserts");
			}
			Assert.assertEquals(sch,schpg);
		}	catch (Exception e) {
			testFail(e.getMessage());
		}
		String sch = driver.findElement(By.className("lighter")).getText();
		Assert.assertEquals(sch,schpg);
	}

	public void addToCart(String crtck) throws IOException {
		logger = report.createTest("cart page");							
		try {
			driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]/option[2]")).click();
			//explicit Wait for 20 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div")).click();
			//Add To Cart
			WebElement cart = driver.findElement(addtocart);
			wait.until(ExpectedConditions.visibilityOf(cart));
			cart.click();
			
			//taking screenshot for cart page
			File crtpg=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(crtpg, new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\cart page.jpg"));

			//Proceed To buy 
			WebElement Proceed = driver.findElement(proceed);
			wait.until(ExpectedConditions.visibilityOf(Proceed));
			Proceed.click();
			
			//Total checking
			WebElement total = driver.findElement(summary);
			wait.until(ExpectedConditions.visibilityOf(total));
			total.click();
			String crt = driver.getTitle();
			Assert.assertEquals(crtck, crt);
			if(crt.matches(crtck)) {
				testPass("cart page verified");
			}
			else {
				testFail("test fail due to invalid assert");
			}
		
		}
		catch (Exception e) {
			testFail(e.getMessage());
		}

	}

	public  void details(String payck) throws IOException {
		logger = report.createTest("payment page");
		try {
			
			//Address
			driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
		
			//Agree Terms
			driver.findElement(By.id("cgv")).click();

			File ship=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(ship, new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\shipping page.jpg"));

			//Shipping Button
			driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']")).click();
			String pay = driver.findElement(By.className("page-heading")).getText();

			//verifing paymentpage
			if(pay.equals(payck)) {
				testPass("website works successfully");
			}
			else {
				testFail("test fail due to invalid assert");
			}
		
		}
		catch (Exception e) {
			testFail(e.getMessage());
		}
		
		  String pay = driver.findElement(By.className("page-heading")).getText();
		 
		  assertEquals(pay,payck);
		 
	}

}
