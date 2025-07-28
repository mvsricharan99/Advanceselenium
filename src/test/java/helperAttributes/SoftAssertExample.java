package helperAttributes;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample 
{
@Test
public void softdemo() throws InterruptedException
{
	String expectedtitle = "Facebook – log in or sign u";
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.facebook.com/");
	 driver.manage().window().maximize();
	 Thread.sleep(3000);
	 driver.findElement(By.name("email")).sendKeys("r1@gmail.com");
	 @Nullable
	 String actualtitle = driver.getTitle();
	 // create an object of softAssert 
	 SoftAssert soft = new SoftAssert();
	 soft.assertEquals(actualtitle, expectedtitle);
	 System.out.println("step1");
	 System.out.println("step2");
	 //soft.assertAll();
	 //driver.quit();
	 try {
	soft.assertAll(); // Check all soft asserts here
		} 
	 finally 
	 {
	driver.quit();    // Ensure browser is closed regardless of test result
		}
}
}
