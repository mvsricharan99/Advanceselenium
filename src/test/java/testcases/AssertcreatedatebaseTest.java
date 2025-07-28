package testcases;

    import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	import Excelfileutility.readdatafromexcel;
	import POM.Homepage;
	import POM.campaignpage;
	import baseClass.BaseClass;
	import javautility.javautility;
	import webdriverutility.webdriverutility;
	@Listeners(ListenersUtility.ListenersImplementation.class)
	public class AssertcreatedatebaseTest extends BaseClass
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
		 //int ran = jtil.getrandomnumber();
		 String CampaignName = campname2;
		//click on create campaign
		 
	     Homepage hp = new Homepage(driver);
		 hp.getCreatecampaign().click();
		 
		 campaignpage cp = new campaignpage(driver);
		 cp.getCampname().sendKeys(CampaignName);
		 cp.getTargetsize().sendKeys(size2);
		 web.passinput(driver,cp.getExpectedclosedate() , jtil.togetrequaired(3));
		 cp.getCampsubmit().click();
		 Thread.sleep(5000);
		    //validation
		    WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
			web.waitforvisibilityofelement(driver, toast);
			String msg = toast.getText();
            Assert.assertEquals(msg,"Campaign "+CampaignName+" Successfully Added");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		// Now wait for close button inside toast to be clickable
    		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='close']")));
    		web.clickElementUsingJS(driver, closeBtn);
            // Use JS click to avoid intercept issues
            //((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
			//hp.getClosemsg().click();
			}
	}

