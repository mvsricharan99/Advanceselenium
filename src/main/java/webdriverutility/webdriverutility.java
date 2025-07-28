package webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility 
{
	//WebDriver driver = new EdgeDriver();
	public void waitforpagetoload(WebDriver driver)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitforvisibilityofelement(WebDriver driver,WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchtoFrame(WebDriver driver,int index)
	{
	driver.switchTo().frame(index);
	}
	public void switchtoFrame(WebDriver driver,String nameorId)
	{
	driver.switchTo().frame(nameorId);
}
	public void switchtoFrame(WebDriver driver,WebElement frameelement)
	{
	driver.switchTo().frame(frameelement);
	}
	public void switchtoAlertandAccept(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
	public void switchtoAlertandDismiss(WebDriver driver)
	{
	driver.switchTo().alert().dismiss();
	}
	public String switchtoAlertandGettext(WebDriver driver)
	{
	String text = driver.switchTo().alert().getText();
	return text;
	}
	public void switchtoAlertandsendkeys(WebDriver driver,String text)
	{
	driver.switchTo().alert().sendKeys(text);
	}
	public void select(WebElement element,int index)
	{
	Select sel = new Select(element);
	sel.selectByIndex(index);
	}
	public void select(WebElement element,String value)
	{
	Select sel = new Select(element);
	sel.selectByValue(value);
	}
	public void select(String text,WebElement element)
	{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
	}
	public void mousehoveronweblement(WebDriver driver,WebElement element)
	{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
	}
	public void clickonweblement(WebDriver driver,WebElement element)
	{
	Actions act = new Actions(driver);
	act.moveToElement(element).click().perform();
	}
	public void doubleclickonwebelement(WebDriver driver,WebElement element)
	{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
	}
	public void rightclickonwebelement(WebDriver driver,WebElement element)
	{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
	}
	public void passinput(WebDriver driver,WebElement element,String text)
	{
	Actions act = new Actions(driver);
	act.click(element).sendKeys(text).perform();
	}
	public void switchtowindow(WebDriver driver)
	{
	Set<String> allwinid = driver.getWindowHandles();
	for(String id : allwinid)
	{
	driver.switchTo().window(id);
	}
	}
	public void takesscreenshot(WebDriver driver,String filename) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File perm = new File("./errorshots"+ filename +".png");
	org.openqa.selenium.io.FileHandler.copy(temp, perm);
	}
	public void toscrollby(WebDriver driver, int x, int y)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollby("+x+", "+y+")");
	}
	public void clickElementUsingJS(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
}

	
	
	