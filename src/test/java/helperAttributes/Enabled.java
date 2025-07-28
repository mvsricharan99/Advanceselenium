package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled 
{
@Test(enabled = true)
public void all()
{
Reporter.log("all done",true);
}
@Test(enabled = false)
public void all1()
{
Reporter.log("all1 done",true);
} 
@Test
public void al10()
{
Reporter.log("al10 done",true);
} 
}
