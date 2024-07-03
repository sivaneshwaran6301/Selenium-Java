package Testing.automationproject;

import java.io.IOException;


import org.testng.annotations.Test;

import base.Base;
import pages.Signinpage;

public class signinpagetest extends Base {
	
	
	Signinpage sg= new Signinpage();
	@Test(priority = 1)
	public void valid() throws IOException {
		
		//Implementation of test inputs in signinpage
		sg.signIn(Base.excel().getRow(1).getCell(0).getStringCellValue(),Base.excel().getRow(1).getCell(1).getStringCellValue(),Base.excel().getRow(1).getCell(2).getStringCellValue());
	}
	
	@Test(priority = 2)
	public void inValid() throws IOException {

		//Implementation of test inputs in signinpage 
		sg.signIn(Base.excel().getRow(3).getCell(0).getStringCellValue(),Base.excel().getRow(1).getCell(1).getStringCellValue(),Base.excel().getRow(3).getCell(2).getStringCellValue());
	}

	

}
