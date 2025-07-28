package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.Homepage;
import POM.Loginpage;
import Propertiesfileutility.getdatafrompropertiesfile;

public class BaseClass 
{
public WebDriver driver = null;
public static WebDriver sdriver = null;
public getdatafrompropertiesfile got = new getdatafrompropertiesfile();

@BeforeSuite(groups = {"Smoke","Regression"})
public void beforesuite()
{
Reporter.log("DB Connectivity open",true);
}

@BeforeTest(groups = {"Smoke","Regression"})
public void beforetest()
{
System.out.println("preconditions");
}

@BeforeClass(groups = {"Smoke","Regression"})
public void beforeclass() throws IOException
{
String BROWSE = got.getdatafrompropertiesfile("Browser");
if(BROWSE.equals("Edge"))
{
driver = new EdgeDriver();
}
else if(BROWSE.equals("Chrome"))
{
driver = new ChromeDriver();
}
else if(BROWSE.equals("Firefox"))
{
driver = new FirefoxDriver();
}
sdriver=driver;
System.out.println("launching browser");
driver.manage().window().maximize();
String url = got.getdatafrompropertiesfile("URL");
driver.get(url);
}

/*@Parameters("BROWSE")
@BeforeClass(groups = {"Smoke","Regression"})
public void beforeclass(String BROWSE) throws IOException
{
//String BROWSE = got.getdatafrompropertiesfile("Browser");
if(BROWSE.equals("Edge"))
{
driver = new EdgeDriver();
}
else if(BROWSE.equals("Chrome"))
{
driver = new ChromeDriver();
}
else if(BROWSE.equals("Firefox"))
{
driver = new FirefoxDriver();
}
System.out.println("launching browser");
driver.manage().window().maximize();
String url = got.getdatafrompropertiesfile("URL");
driver.get(url);
}*/

@BeforeMethod(groups = {"Smoke","Regression"})
public void beforemethod() throws IOException
{
	getdatafrompropertiesfile got = new getdatafrompropertiesfile();
    String BROWSE = got.getdatafrompropertiesfile("Browser");
	String url = got.getdatafrompropertiesfile("URL");
	String UserName = got.getdatafrompropertiesfile("username");
	String PassWord = got.getdatafrompropertiesfile("password");
	 //driver.get(url);
	    Loginpage lp = new Loginpage(driver);
	    lp.getUN().sendKeys(UserName);
	    lp.getPW().sendKeys(PassWord);
	    lp.getLoginbtn().click();
	    System.out.println("login done");
}

@AfterMethod(groups = {"Smoke","Regression"})
public void aftermethod()
{
	 Homepage hp = new Homepage(driver);
	 hp.getUsericon().click();
	 hp.getLogoutbtn().click();
	 System.out.println("logout done");
}
@AfterClass(groups = {"Smoke","Regression"})
public void afterclass()
{
driver.quit();
System.out.println("closing browser");
}
@AfterTest(groups = {"Smoke","Regression"})
public void aftertest()
{
System.out.println("post conditions");
}
@AfterSuite(groups = {"Smoke","Regression"})
public void aftersuite()
{
System.out.println("close DB connectivity");
}
}
