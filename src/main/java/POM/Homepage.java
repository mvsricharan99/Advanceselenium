package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;
	   public Homepage(WebDriver driver)
	   {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	   @FindBy(linkText = "Campaigns")
	   private WebElement camp;
	   
	   @FindBy(linkText = "Contacts")
	   private WebElement cont;
	   
	   @FindBy(linkText = "Products")
	   private WebElement prod;
	   
	   public WebElement getAddprod() {
		return Addprod;
	}
	   @FindBy(xpath = "//span[text()='Add Product']")
	   private WebElement Addprod;
	   
	   @FindBy(xpath = "//span[text()='Create Campaign']")
	   private WebElement createcampaign;
	   
	   @FindBy(className = "user-icon")
	   private WebElement usericon;
	   
	   @FindBy(xpath = "//div[text()='Logout ']")
	   private WebElement Logoutbtn;
	   
	   @FindBy(xpath = "//div[@role='alert']")
	   private WebElement toastmsg;
	   
	   @FindBy(xpath = "//button[@aria-label='close']")
	   private WebElement closemsg;
	   
	public WebElement getCamp() {
		return camp;
	}

	public WebElement getCont() {
		return cont;
	}

	public WebElement getProd() {
		return prod;
	}

	public WebElement getCreatecampaign() {
		return createcampaign;
	}

	public WebElement getUsericon() {
		return usericon;
	}

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}

	public WebElement getClosemsg() {
		return closemsg;
	}
	   
}
