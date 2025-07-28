package helperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class FacebookLoginScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
       // Take 3 screenshots with delays
        for (int i = 1; i <= 3; i++) 
        {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\HP\\Downloads\\homepage_screenshot" + i + ".png");
            FileHandler.copy(scrFile, destFile);
            System.out.println("Saved screenshot:- " + destFile);
            Thread.sleep(2000); 
        }
        driver.quit();
    }
}

