package helperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Threadpoolsize 
{
@Test(invocationCount = 6,threadPoolSize = 3)
public void login() throws InterruptedException
{
	WebDriver driver = new ChromeDriver();
	Reporter.log("login executed",true);
	Thread.sleep(3000);
	driver.quit();
	}
}
