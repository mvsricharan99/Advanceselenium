package Propertiesfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class getdatafrompropertiesfile 
{
	public String getdatafrompropertiesfile(String key) throws IOException
	{
	FileInputStream fis = new FileInputStream("./Configdata/ninzacrm.properties");
    //create object of property file
    Properties prop = new Properties();
    prop.load(fis);
    String value = prop.getProperty(key);
    return value;
   
  }
}