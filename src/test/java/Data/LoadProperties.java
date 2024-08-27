package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	//load prop. file from folder
	
	public static Properties userData= LoadProperties("D:/Prog/Eclips projects/TAF/src/main"
					+ "/java/properties/userData.properties");
	
	private static Properties LoadProperties(String path) {
		Properties pro = new Properties();
		//stream for file reading	
	try {
		FileInputStream stream = new FileInputStream(path);
		pro.load(stream);
	} catch (FileNotFoundException e) {
		System.out.println("error occured"+ e.getMessage());
	} catch (IOException e) {
		System.out.println("error occured"+ e.getMessage());
	}catch (NullPointerException e) {
		System.out.println("error occured"+ e.getMessage());
	}
	return pro;
	}

}
