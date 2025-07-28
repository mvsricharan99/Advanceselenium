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
	import POM.Addproduct;
	import POM.Homepage;
	import baseClass.BaseClass;
	import javautility.javautility;
	import webdriverutility.webdriverutility;
	@Listeners(ListenersUtility.ListenersImplementation.class)
	public class AssertcreateprodbaseTest extends BaseClass
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
		 //int ran = jtil.getrandomnumber();
		 String CampaignName = pname+jtil.getrandomnumber();
		 Thread.sleep(1000);
	     //click on Add Product
		 Homepage hp = new Homepage(driver);
	     hp.getProd().click();
		 Thread.sleep(1000);
		 hp.getAddprod().click();
		 
		//enter mandatory fields
		    Addproduct ap = new Addproduct(driver);
		    ap.getProductid();
		    ap.getProductname().sendKeys(CampaignName);
		    ap.getProductcategory().sendKeys("Electricals");
		    ap.getQuantity().clear();
		    ap.getQuantity().sendKeys(psize);
		    ap.getPrice().clear();
		    ap.getPrice().sendKeys(pprize);
		    ap.getVendorid().sendKeys("VID_001");
		    ap.getAddbtn().click();
		    Thread.sleep(5000);
		    //validation
		    WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
			web.waitforvisibilityofelement(driver, toast);
			String msg = toast.getText();
			Assert.assertEquals(msg,"Product "+CampaignName+" Successfully Added");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Now wait for close button inside toast to be clickable
	    	WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='close']")));
	    	web.clickElementUsingJS(driver, closeBtn);
	        // Use JS click to avoid intercept issues
	        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
			//hp.getClosemsg().click();
		    }
	}

