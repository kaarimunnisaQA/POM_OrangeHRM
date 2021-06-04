package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestUtil.Testutil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		// read the property

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/NewQA/FreeCRM_Page_Object_Model/src/main/java/com/crm/qa/Config_4th_step/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void Initialization() {

		String browsername = prop.getProperty("browsser");

		/*if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}*/
		
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutil.pageloadtimeout, TimeUnit.SECONDS);

		// read the url
		driver.get(prop.getProperty("url"));

	}
}
