package Testing.automationproject;

import org.testng.annotations.Test;

import base.Base;
import pages.Purchasepage;
import pages.Signinpage;

import java.io.IOException;

public class Purchasepagetest extends Base {
 
 
Signinpage sg= new Signinpage();
Purchasepage pp = new Purchasepage();

@Test(priority = 1)
public void purchaseCasual() throws IOException {
	
	sg.signIn( Base.excel().getRow(1).getCell(0).getStringCellValue(),Base.excel().getRow(1).getCell(1).getStringCellValue(), Base.excel().getRow(1).getCell(2).getStringCellValue());
	
	pp.search(Base.excel().getRow(1).getCell(4).getStringCellValue(),Base.excel().getRow(1).getCell(3).getStringCellValue());
	pp.addToCart(Base.excel().getRow(1).getCell(5).getStringCellValue());
	pp.details(Base.excel().getRow(1).getCell(6).getStringCellValue());

}
@Test(priority = 2)
public void purchaseSummer() throws IOException {

	sg.signIn( Base.excel().getRow(1).getCell(0).getStringCellValue(),Base.excel().getRow(1).getCell(1).getStringCellValue(), Base.excel().getRow(1).getCell(2).getStringCellValue());
	
	pp.search(Base.excel().getRow(2).getCell(4).getStringCellValue(),Base.excel().getRow(2).getCell(3).getStringCellValue());
	pp.addToCart(Base.excel().getRow(1).getCell(5).getStringCellValue());
	pp.details(Base.excel().getRow(1).getCell(6).getStringCellValue());

}

	
}
