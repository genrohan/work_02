package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BeforeAfterClass {

	static WebDriver driver;
	static String path="C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe";	//chromedriver path
	
	//@Before
	public static void start() {
		//String url = "https://www.flipkart.com";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get(url);
	}
	
	//@After
	public void afterTest() {
	driver.close();
	}
}
