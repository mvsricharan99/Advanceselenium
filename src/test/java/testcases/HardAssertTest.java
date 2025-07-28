package testcases;


	import java.io.IOException;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import org.apache.poi.EncryptedDocumentException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
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
		public class HardAssertTest extends BaseClass
		{
		@Test(groups = "Smoke")
		public void createcampaign() throws EncryptedDocumentException, IOException, InterruptedException
		{
			 readdatafromexcel read = new readdatafromexcel();
			 webdriverutility web = new webdriverutility();
			 javautility jtil = new javautility();
			 //read data from excel
			 String campname = read.readdatafromexcel("Campaign", 2, 2);
			 String baseName = campname;
			 String size = read.readdatafromexcel("Campaign", 2, 3);
			 int ran = jtil.getrandomnumber();
			 String CampaignName = campname+ran;
			 //click on create campaign
			 
			 Homepage hp = new Homepage(driver);
			 hp.getCreatecampaign().click();
			 
			 //enter mandatory fields
			 campaignpage cp = new campaignpage(driver);
			 cp.getCampname().sendKeys(CampaignName);
			 cp.getTargetsize().sendKeys(size);
			 cp.getCampsubmit().click();
			 Thread.sleep(5000);
			 //validation
			 
		    WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		    web.waitforvisibilityofelement(driver, toast);
	        String msg = toast.getText();

	        Assert.assertTrue(msg.startsWith("Campaign " + baseName), 
	                "Toast message doesn't start with expected campaign name. Actual: " + msg);

	            Assert.assertTrue(msg.contains("Successfully Added"), 
	                "Toast message doesn't contain 'Successfully Added'. Actual: " + msg);
	            
	        // Optionally, extract the full campaign name if needed
	        Pattern p = Pattern.compile("Campaign (.+) Successfully Added");
	        Matcher m = p.matcher(msg);
	        if (m.find()) {
	            String actualCreatedName = m.group(1);
	            System.out.println("Campaign created: " + actualCreatedName);
	        }

	        // Optional: close the toast
	        try {
	            WebElement closeBtn = driver.findElement(By.xpath("//button[@aria-label='close']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
	        } catch (Exception e) {
	            System.out.println("Toast close button not clickable or not found.");
	        }
          }
		}

