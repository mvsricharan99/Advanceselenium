package helperAttributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel 
{
@Test(dataProvider = "logindetails")
public void login(String username,String password) throws InterruptedException
{
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//login to instagram
	driver.get("https://www.instagram.com/");
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	driver.quit();
}
@DataProvider
public Object[][] logindetails() throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream("./TestData/dataprovider.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int rowcount = sh.getLastRowNum();
	Object[][] obj = new Object[rowcount][2];
	for(int i=0;i<rowcount;i++)
	{
	obj[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
	obj[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
	}
	return obj;
}
	
}