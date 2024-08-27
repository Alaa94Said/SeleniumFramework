package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class TestBase {

	public static WebDriver driver;
	public static String downloadPath = System.getProperty("/Users/lillys/Desktop/Lilly/Java workspace/NopCommerce/Downloads");
	
	
	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return options;
	}
	
	
	@BeforeSuite
	@Parameters ({"Browser"})
	
	public void startDriver(@Optional("chrome")String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/lillys/Desktop/Lilly/setup/chromedriver");
			driver= new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/lillys/Desktop/Lilly/Java workspace/NopCommerce/Drivers/geckodriver 2");
			driver= new FirefoxDriver();
		}
		
		//Headless Browser Testing
				else if (browsername.equalsIgnoreCase("headless")) {
					
					DesiredCapabilities caps = new DesiredCapabilities();
					//caps.setJavascriptEnabled(true);
					
					caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
							System.getProperty("/Users/lillys/Desktop/Lilly/setup/phantomjs.exe"));
					
					String[] phantomJsArgStrings = {"--web-security=no","--ignore-ssl--errors=yes"};
					caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgStrings);
					
					driver = new PhantomJSDriver(caps);
					
				}
	
	driver.manage().window().maximize();
	driver.get("https://demo.nopcommerce.com/");
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	

	
	
	@AfterSuite
	public void stopDriver() {
		driver.quit();
		//driver.manage().window().minimize();
	}
	
	// take screenshot when fail and add to folder
	
	
	
}
