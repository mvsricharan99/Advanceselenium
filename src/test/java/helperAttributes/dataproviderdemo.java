package helperAttributes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderdemo 
{
@Test(dataProvider = "logindetails")
public void login(String username,String password)
{
System.out.println(username+"==="+password);
}

@DataProvider(name = "logindetails",indices = {2,4})
public Object[][] logindetails()
{
    Object[][] obj = new Object[3][2];
    obj[0][0]="virat";
    obj[0][1]="v123";
    obj[1][0]="sachin";
    obj[1][1]="v456";
    obj[2][0]="rohit";
    obj[2][1]="v789";
    return obj;
	
}
}
