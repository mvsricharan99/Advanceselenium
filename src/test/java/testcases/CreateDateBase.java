package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Excelfileutility.readdatafromexcel;
import POM.Homepage;
import POM.campaignpage;
import baseClass.BaseClass;
import javautility.javautility;
import webdriverutility.webdriverutility;

public class CreateDateBase extends BaseClass
{
@Test(groups = "Regression")
public void createdate() throws EncryptedDocumentException, IOException, InterruptedException
{
	 readdatafromexcel read = new readdatafromexcel();
	 webdriverutility web = new webdriverutility();
	 javautility jtil = new javautility();
	 //read data from excel
	 String campname2 = read.readdatafromexcel("Campaign", 1, 2);
	 String size2 = read.readdatafromexcel("Campaign", 1, 3);
	 
	//click on create campaign
	 
     Homepage hp = new Homepage(driver);
	 hp.getCreatecampaign().click();
	 
	 campaignpage cp = new campaignpage(driver);
	 cp.getCampname().sendKeys(campname2 +jtil.getrandomnumber());
	 cp.getTargetsize().sendKeys(size2);
	 web.passinput(driver,cp.getExpectedclosedate() , jtil.togetrequaired(-3));
	 cp.getCampsubmit().click();
	 Thread.sleep(3000);
	    //validation
	    WebElement toast = hp.getToastmsg();
		web.waitforvisibilityofelement(driver, toast);
		String msg = toast.getText();
		    
		    if(msg.contains(campname2))
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
