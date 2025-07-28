package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class proertiesfile {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
    FileInputStream fis = new FileInputStream("./Configdata/ninzacrm.properties");
    //create object of property file
    Properties prop = new Properties();
    //load all keys
    prop.load(fis);
    //get properties
    String Browse = prop.getProperty("Browser");
    String Url = prop.getProperty("URL");
    String User = prop.getProperty("username");
    String pwd = prop.getProperty("password");
    
    WebDriver driver = null;
    
    if(Browse.equals("Edge"))
    {
    driver = new EdgeDriver();
    }
    if(Browse.equals("Chrome"))
    {
    driver = new ChromeDriver();
    }
    if(Browse.equals("Firefox"))
    {
    driver = new FirefoxDriver();
    }
    
    //actual script
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(Url);
    driver.findElement(By.id("username")).sendKeys(User);
    driver.findElement(By.id("inputPassword")).sendKeys(pwd);
    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}

}
