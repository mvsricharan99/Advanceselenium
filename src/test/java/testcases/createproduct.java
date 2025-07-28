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

public class createproduct {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		getdatafrompropertiesfile got = new getdatafrompropertiesfile();
		String BROWSE = got.getdatafrompropertiesfile("Browser");
		String url = got.getdatafrompropertiesfile("URL");
		String UserName = got.getdatafrompropertiesfile("username");
		String PassWord = got.getdatafrompropertiesfile("password");
		
		readdatafromexcel read = new readdatafromexcel();
		String pname = read.readdatafromexcel("Product", 1, 2);
		String psize = read.readdatafromexcel("Product", 1, 3);
		String pprize = read.readdatafromexcel("Product", 1, 4);
		
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
	    
	    //Test validation
	    WebElement productsLink = driver.findElement(By.linkText("Products"));
	    productsLink.click();
	    
	    WebElement addProductSpan = driver.findElement(By.xpath("//span[text()='Add Product']"));
	    addProductSpan.click();
	    WebElement productNameInput = driver.findElement(By.xpath("//input[@name='productName']"));
	    productNameInput.sendKeys(pname+jtil.getrandomnumber());
	    
	    WebElement categoryDropdown = driver.findElement(By.name("productCategory"));
	    web.select(categoryDropdown, "Electricals");
	    
	    WebElement quantityInput = driver.findElement(By.name("quantity"));
	    quantityInput.clear();
	    quantityInput.sendKeys(psize);
	    
	    WebElement priceInput = driver.findElement(By.name("price"));
	    priceInput.clear();          
	    priceInput.sendKeys(pprize);
	    
	    WebElement vendorDropdown = driver.findElement(By.name("vendorId"));
	    web.select(vendorDropdown, "VID_001");
	    WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
	    addButton.click();
	    //Alert message
	    WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
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
	    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	    
	    //logout
	    WebElement logout = driver.findElement(By.xpath("//div[@class='user-icon']"));
	    web.mousehoveronweblement(driver, logout);
	    WebElement logout1 = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	    web.clickonweblement(driver, logout1);
	    }
}

	    
	    
	    

