package testcases;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Excelfileutility.readdatafromexcel;
import POM.Addproduct;
import POM.Homepage;
import baseClass.BaseClass;
import javautility.javautility;
import webdriverutility.webdriverutility;
@Listeners(ListenersUtility.ListenersImplementation.class)

public class CreateProductBase extends BaseClass
{
@Test(groups = "Regression")
public void createproduct() throws EncryptedDocumentException, IOException, InterruptedException
{
	readdatafromexcel read = new readdatafromexcel();
	 webdriverutility web = new webdriverutility();
	 javautility jtil = new javautility();
	 
	 String pname = read.readdatafromexcel("Product", 1, 2);
	 String psize = read.readdatafromexcel("Product", 1, 3);
	 String pprize = read.readdatafromexcel("Product", 1, 4);
	 Thread.sleep(1000);
     //click on Add Product
	 Homepage hp = new Homepage(driver);
     hp.getProd().click();
	 Thread.sleep(1000);
	 hp.getAddprod().click();
	 
	//enter mandatory fields
	    Addproduct ap = new Addproduct(driver);
	    ap.getProductid();
	    ap.getProductname().sendKeys(pname+jtil.getrandomnumber());
	    ap.getProductcategory().sendKeys("Electricals");
	    ap.getQuantity().clear();
	    ap.getQuantity().sendKeys(psize);
	    ap.getPrice().clear();
	    ap.getPrice().sendKeys(pprize);
	    ap.getVendorid().sendKeys("VID_001");
	    ap.getAddbtn().click();
	    Thread.sleep(1000);
	  //validation
	    WebElement toast = hp.getToastmsg();
		web.waitforvisibilityofelement(driver, toast);
		String msg = toast.getText();
		    
		    if(msg.contains(pname))
		    {
		    System.out.println("campaign is created");
		    }
		    else
		    {
		    System.out.println("campaign not created");
		    }
		    hp.getClosemsg().click();
	    }
}
