package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaignpage 
{
	WebDriver driver;
	   public campaignpage(WebDriver driver)
	   {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	   public WebDriver getDriver() {
		return driver;
	}
	   @FindBy(name =  "campaignName")
	   private WebElement campname;
	   
	   @FindBy(name =  "campaignStatus")
	   private WebElement campstatus;
	   
	   public WebElement getCampname() {
		return campname;
	}

	public WebElement getCampstatus() {
		return campstatus;
	}

	public WebElement getTargetsize() {
		return targetsize;
	}

	public WebElement getExpectedclosedate() {
		return expectedclosedate;
	}

	public WebElement getCampsubmit() {
		return campsubmit;
	}
	   @FindBy(name =  "targetSize")
	   private WebElement targetsize;
	   
	   @FindBy(name =  "expectedCloseDate")
	   private WebElement expectedclosedate;
	   
	   @FindBy(xpath = "//button[text()='Create Campaign']")
	   private WebElement campsubmit;
}
