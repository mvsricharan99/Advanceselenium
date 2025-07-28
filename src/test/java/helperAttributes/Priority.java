package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority 
{
@Test (priority = 0)
public void amazon()
{
Reporter.log("amazon executed",true);
}
@Test (priority = -2)
public void bms()
{
Reporter.log("bms executed",true);
}
@Test (priority = 3)
public void flipkart()
{
Reporter.log("flipkart executed",true);
}
}
