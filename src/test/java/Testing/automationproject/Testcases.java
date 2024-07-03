package Testing.automationproject;

import org.testng.annotations.Test;
import java.io.IOException;

import base.Base;
import pages.Purchasepage;
import pages.Signinpage;

public class Testcases extends Base



{
	Signinpage sn = new Signinpage();
	Purchasepage pp = new Purchasepage();


	@Test
	public void testRun() throws IOException
	{

		sn.signIn(Base.excel().getRow(1).getCell(0).getStringCellValue(),"Password@",Base.excel().getRow(1).getCell(2).getStringCellValue());
		pp.search("\"CASUAL DRESS\"",Base.excel().getRow(1).getCell(2).getStringCellValue());
		pp.addToCart(Base.excel().getRow(1).getCell(5).getStringCellValue());
		pp.details(Base.excel().getRow(1).getCell(6).getStringCellValue());

	}


}
