package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BeforeAfterClass extends Path {

	WebDriver driver;
	
	public BeforeAfterClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@Before
	public void startTest(String url) {
		System.setProperty("webdriver.chrome.driver", driver_path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	/*@After
	public void afterTest() {
	driver.close();
	}*/
}
