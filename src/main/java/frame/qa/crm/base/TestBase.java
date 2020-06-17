
package frame.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import frame.qa.crm.util.TestUtil;
import frame.qa.crm.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					"C:\\ Users\\admin\\eclipse-workspace\\framework\\src\\main\\java\\"
							+ "frame\\qa\\crm\\configuration\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\jars\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\jars\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		
		e_driver.register(eventListener);
		driver=e_driver;
		
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
