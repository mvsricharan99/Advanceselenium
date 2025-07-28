package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Excelfileutility.readdatafromexcel;
import POM.Addproduct;
import POM.Homepage;
import POM.Loginpage;
import Propertiesfileutility.getdatafrompropertiesfile;
import javautility.javautility;
import webdriverutility.webdriverutility;

public class createproductPOM {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		getdatafrompropertiesfile got = new getdatafrompropertiesfile();
		//String BROWSE = got.getdatafrompropertiesfile("Browser");
		String url = got.getdatafrompropertiesfile("URL");
		String UserName = got.getdatafrompropertiesfile("username");
		String PassWord = got.getdatafrompropertiesfile("password");
		
		readdatafromexcel read = new readdatafromexcel();
		String pname = read.readdatafromexcel("Product", 1, 2);
		String psize = read.readdatafromexcel("Product", 1, 3);
		String pprize = read.readdatafromexcel("Product", 1, 4);
		
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
	    
	    Thread.sleep(3000);
	    Homepage hp = new Homepage(driver);
	    hp.getProd().click();
	    Thread.sleep(3000);
	    hp.getAddprod().click();
	    
	    javautility jtil = new javautility();
	    
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
	    
	    WebElement toast = hp.getToastmsg();
	    web.waitforvisibilityofelement(driver, toast);
	    String msg = toast.getText();
	    
	    if(msg.contains(pname))
	    {
	    System.out.println("product is created");
	    }
	    else
	    {
	    System.out.println("product not created");
	    }
	    hp.getClosemsg().click();
	    
	    hp.getUsericon().click();
	    hp.getLogoutbtn().click();
	   }
}
