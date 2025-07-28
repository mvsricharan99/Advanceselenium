package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Readdatafromjson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
    {
		// TODO Auto-generated method stub
    //parse the json physical file into java object using json parser class
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./TestData/TestScriptDataAdv.xlsx"));
		//convert the java object into json object(type casting)
		JSONObject obj1 = (JSONObject)obj;
		//read the data using get() by using key
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("Url"));
		System.out.println(obj1.get("Username"));
		System.out.println(obj1.get("password"));
		String browser = obj1.get("Browser").toString();
	}

}
