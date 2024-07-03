package pages;


import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import base.Base;
public class Signinpage extends Base {

	
	By email = By.id("email");
	By password = By.id("passwd");



	public  void signIn(String userName,String passwd,String ass) throws IOException {
		logger = report.createTest("signin page");
	
		try {
			//Sign in
			driver.findElement(By.linkText("Sign in")).click();

			//Entering Email and Password
			driver.findElement(email).sendKeys(userName);
			byte[] passWord = Base64.decodeBase64(passwd);
			driver.findElement(password).sendKeys(new String(passWord));
			
			//taking screenshot for signinpage
			File signIn=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(signIn, new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\sign in page.jpg"));

			//submitting sign in inputs
			driver.findElement(By.id("SubmitLogin")).click();

			String sig =driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
			if(sig.equals(ass))
			{		
				testPass("signin page verified");
			}		
			else {
				testFail("test fail due to invalid asserts");
			}
			
		}

		catch (Exception e) {
			testFail(e.getMessage());
		}	
		String sig =driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
		Assert.assertEquals(sig,ass);

	}

}
