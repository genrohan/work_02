package stepdefn;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LogInStepDefn {

	String c_uname="";		//correct mail id
	String c_pswd = "";		//correct password
	
	String inc_uname="abc123";
	String inc_pswd = "abc123";
	
	WebDriver driver;
	
	@Given("User is on Flipkart's HomePage")
	public void user_in_on_Flipkarts_Homepage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//String url = "https://www.flipkart.com";
		//utility.BeforeAfterClass.start(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
	}
	
	
	
	@When("User clicks on Login")
	public void user_click_oin_Login() throws Exception {
	   driver.findElement(By.linkText("Login")).click();
	   //clicking on signin button
	   Thread.sleep(3000); 
	}
		
	
	@When("User enters details")
	public void user_enters_details() {
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(c_uname);
		driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys(c_pswd);
		//entering mail id
	}
	
	@When("User clicks on final Login")
	public void user_clicks_on_final_login() throws Exception {
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Thread.sleep(3000);
	}
	
	
	@Then("Verify user is logged in")
	public void verify_user_is_login() throws Exception {
		String u_name= driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).getText();
		//reading the username in the home page
		System.out.println(u_name);
		Thread.sleep(3000);
		driver.close();
	}
		
	
	@When("User enters wrong details")
	public void user_enters_wrong_details() {
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(inc_uname);
		driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys(inc_pswd);
		//entering mail id
	}
	
	
	@Then("User can see error message")
	public void user_can_see_error_message() {
		String msg=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")).getText();
		System.out.println(msg);
		driver.close();
	}
	
	
	@Then("User verifies login credentials from a json file")
	public void user_verifies_login_credentials_from_a_json_file() throws InterruptedException, IOException, ParseException {
		utility.JsonDataRead.readJSON();
	}
	
}

