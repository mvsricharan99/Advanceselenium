package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addproduct 
{
	WebDriver driver;
	   public Addproduct(WebDriver driver)
	   {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	   @FindBy(name =  "productId")
	   private WebElement productid;
	   
	   @FindBy(name =  "productName")
	   private WebElement productname;
	   
	   @FindBy(name =  "productCategory")
	   private WebElement productcategory;
	   
	   @FindBy(name =  "quantity")
	   private WebElement Quantity;
	   
	   @FindBy(name =  "price")
	   private WebElement Price;
	   
	   @FindBy(name =  "vendorId")
	   private WebElement vendorid;
	   
	   public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductid() {
		return productid;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductcategory() {
		return productcategory;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getPrice() {
		return Price;
	}

	public WebElement getVendorid() {
		return vendorid;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}
	@FindBy(xpath = "//button[text()='Add']")
	   private WebElement addbtn;
	   
	   
}
