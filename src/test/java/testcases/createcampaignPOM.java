package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Excelfileutility.readdatafromexcel;
import POM.Homepage;
import POM.Loginpage;
import POM.campaignpage;
import Propertiesfileutility.getdatafrompropertiesfile;
import javautility.javautility;
import webdriverutility.webdriverutility;

public class createcampaignPOM {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		getdatafrompropertiesfile got = new getdatafrompropertiesfile();
		//String BROWSE = got.getdatafrompropertiesfile("Browser");
		String url = got.getdatafrompropertiesfile("URL");
		String UserName = got.getdatafrompropertiesfile("username");
		String PassWord = got.getdatafrompropertiesfile("password");
		
		readdatafromexcel read = new readdatafromexcel();
		String campname = read.readdatafromexcel("Campaign", 1, 2);
		String size = read.readdatafromexcel("Campaign", 1, 3);
		
		webdriverutility web = new webdriverutility();
		WebDriver driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    web.waitforpagetoload(driver);
	    //login to ninza crm
	    driver.get(url);
	    Loginpage lp = new Loginpage(driver);
	    lp.getUN().sendKeys(UserName);
	    lp.getPW().sendKeys(PassWord);
	    lp.getLoginbtn().click();
	   
	    javautility jtil = new javautility();
	   
	    Homepage hp = new Homepage(driver);
	    hp.getCreatecampaign().click();
	   
	    campaignpage cp = new campaignpage(driver);
	    cp.getCampname().sendKeys(campname +jtil.getrandomnumber());
	    cp.getTargetsize().sendKeys(size);
	    cp.getCampsubmit().click();
	   
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
	    
	    hp.getUsericon().click();
	    hp.getLogoutbtn().click();
	}
}
       

