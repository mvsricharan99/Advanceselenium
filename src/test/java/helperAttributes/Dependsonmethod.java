package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dependsonmethod 
{
@Test(enabled = false)
public void createacc()
{
Reporter.log("acc created",true);
}
@Test(dependsOnMethods = "createacc")
public void editacc()
{
	Reporter.log("edited",true);
}
@Test(dependsOnMethods = "editacc")
public void deleteacc()
{
	Reporter.log("deletedacc",true);
}
}
