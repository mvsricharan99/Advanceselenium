package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationPractice 
{
@Test
public void TC001()
{
Reporter.log("testcases done",true);
}
@BeforeMethod
public void beforemethod()
{
Reporter.log("login",true);
}
@AfterMethod
public void aftermethod()
{
Reporter.log("logout",true);
}
@BeforeClass
public void beforeclass()
{
Reporter.log("lauching browser",true);
}
@AfterClass
public void afterclass()
{
Reporter.log("closing browser",true);
}
@BeforeTest
public void beforetest()
{
Reporter.log("preconditions",true);
}
@AfterTest
public void aftertest()
{
Reporter.log("postconditions",true);
}
@BeforeSuite
public void beforesuite()
{
Reporter.log("DB Connectivty open",true);
}
@AfterSuite
public void aftersuite()
{
Reporter.log("DB connectivity close",true);
}
}
