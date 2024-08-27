package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.midi.Patch;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class Helper {
	
	//method to take screenshot when test case fail
	
	public static void captureScreenshot(WebDriver driver, String screenshotname) 
	{
		Path dest= Paths.get("/NopCommerce/ScreenShots",screenshotname+".png");
		try {
			java.nio.file.Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot");
			//e.printStackTrace();
		}
	}

}
