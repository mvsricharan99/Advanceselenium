package testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Excelfileutility.readdatafromexcel;
import Propertiesfileutility.getdatafrompropertiesfile;
import javautility.javautility;
import webdriverutility.webdriverutility;

public class createcampaign {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		getdatafrompropertiesfile got = new getdatafrompropertiesfile();
		String BROWSE = got.getdatafrompropertiesfile("Browser");
		String url = got.getdatafrompropertiesfile("URL");
		String UserName = got.getdatafrompropertiesfile("username");
		String PassWord = got.getdatafrompropertiesfile("password");
		
		readdatafromexcel read = new readdatafromexcel();
		String campname = read.readdatafromexcel("Campaign", 1, 2);
		String size = read.readdatafromexcel("Campaign", 1, 3);
		
		webdriverutility web = new webdriverutility();
		
		 WebDriver driver = null;
		    
		    if(BROWSE.equals("Edge"))
		    {
		    driver = new EdgeDriver();
		    }
		    if(BROWSE.equals("Chrome"))
		    {
		    driver = new ChromeDriver();
		    }
		    if(BROWSE.equals("Firefox"))
		    {
		    driver = new FirefoxDriver();
		    }
		
		//WebDriver driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    web.waitforpagetoload(driver);
	    //login to ninza crm
	    driver.get(url);
	    driver.findElement(By.id("username")).sendKeys(UserName);
	    driver.findElement(By.id("inputPassword")).sendKeys(PassWord);
	    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	    
	    javautility jtil = new javautility();
	    
	    //create campaign
	    driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	    driver.findElement(By.name("campaignName")).sendKeys(campname+ jtil.getrandomnumber());
	    WebElement target = driver.findElement(By.name("targetSize"));
	    target.clear();
	    target.sendKeys(size);
	    driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
	    
	    //validation
	    WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
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
	    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	    
	    //logout
	    WebElement logout = driver.findElement(By.xpath("//div[@class='user-icon']"));
	    web.mousehoveronweblement(driver, logout);
	   
	    WebElement logout1 = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	    web.clickonweblement(driver, logout1);
	   }
}
