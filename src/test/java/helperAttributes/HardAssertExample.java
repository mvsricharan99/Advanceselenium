package helperAttributes;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample 
{
@Test
public void harddemo() throws InterruptedException
{
	 String expectedtitle = "Facebook – log in or sign u";
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.facebook.com/");
	 driver.manage().window().maximize();
	 Thread.sleep(3000);
	 @Nullable
	String actualtitle = driver.getTitle();
	Assert.assertEquals(actualtitle, expectedtitle);
	System.out.println("step1");
	System.out.println("step2");
	driver.quit();
}
}
