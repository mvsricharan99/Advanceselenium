package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Excelfileutility.readdatafromexcel;
import POM.Homepage;
import POM.campaignpage;
import baseClass.BaseClass;
import javautility.javautility;
import webdriverutility.webdriverutility;
@Listeners(ListenersUtility.ListenersImplementation.class)
public class CreateCampaignBase extends BaseClass
{
@Test(groups = "Smoke")
public void createcampaign() throws EncryptedDocumentException, IOException, InterruptedException
{
	 readdatafromexcel read = new readdatafromexcel();
	 webdriverutility web = new webdriverutility();
	 javautility jtil = new javautility();
	 //read data from excel
	 String campname = read.readdatafromexcel("Campaign", 1, 2);
	 String size = read.readdatafromexcel("Campaign", 1, 3);
	 
	 //click on create campaign
	 
	 Homepage hp = new Homepage(driver);
	 hp.getCreatecampaign().click();
	 
	 //enter mandatory fields
	 campaignpage cp = new campaignpage(driver);
	 cp.getCampname().sendKeys(campname +jtil.getrandomnumber());
	 cp.getTargetsize().sendKeys(size);
	 cp.getCampsubmit().click();
	 Thread.sleep(3000);
	 //validation
	 WebElement toast = hp.getToastmsg();
	 web.waitforvisibilityofelement(driver, toast);
	 String msg = toast.getText();
	    
	    if(msg.contains(campname))
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
