package Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {// used as object
	public String Fname, Lname, Email, Password;

	public void JsonReader() throws   IOException, ParseException {

		String filePAth= "D:\\Prog\\Eclips projects\\TAF\\src\\test\\java\\Data\\userData.json";
		File srcFile= new File(filePAth);
		JSONParser parser = new JSONParser();
		JSONArray jarray= (JSONArray)parser.parse(new FileReader(srcFile));

		for (Object jsonObj:jarray ) {
			JSONObject person = (JSONObject) jsonObj;

			Fname= (String)person.get("firstname");
			System.out.println(Fname);
			Lname= (String)person.get("lastname");
			System.out.println(Lname);
			Email=(String) person.get("email");
			System.out.println(Email);
			Password=(String)person.get("password");
			System.out.println(Password);
		}
	}



}
