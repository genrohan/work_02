package stepdefn;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

import org.json.simple.parser.ParseException;



import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import utility.*;

public class LogInStepDefn extends Path{

	//String c_uname="";		//correct mail id
	//String c_pswd = "";		//correct password
	
	//String inc_uname="abc123";
	//String inc_pswd = "abc123";
	
	//WebDriver driver;
	
	@Given("User is on {string} HomePage")
	public void user_in_on_Flipkarts_Homepage(String url)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//String url = "https://www.flipkart.com";
		//utility.BeforeAfterClass.start(url);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://www.flipkart.com");
		BeforeAfterClass.startTest(url);
	}
	
	
	
	@When("User clicks on Login")
	public void user_click_oin_Login() throws Exception {
	   driver.findElement(By.linkText("Login")).click();
	   //clicking on signin button
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	}
		
	
	@When("User enters details")
	public void user_enters_details() {
		driver.findElement(By.xpath(mailfield_XPath)).sendKeys(c_uname);
		driver.findElement(By.xpath(pswdfield_XPath)).sendKeys(c_pswd);
		//entering mail id
	}
	
	@When("User clicks on final Login")
	public void user_clicks_on_final_login() throws Exception {
		driver.findElement(By.xpath(login_XPath)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Then("Verify user is logged in")
	public void verify_user_is_login() throws Exception {
		String u_name= driver.findElement(By.xpath(uname_XPath)).getText();
		//reading the username in the home page
		System.out.println(u_name);
		
		JsonDataRead.logout();
		System.out.println("Valid User");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BeforeAfterClass.afterTest();
	}
		
	
	@When("User enters wrong details")
	public void user_enters_wrong_details() {
		driver.findElement(By.xpath(mailfield_XPath)).sendKeys(inc_uname);
		driver.findElement(By.xpath(pswdfield_XPath)).sendKeys(inc_pswd);
		//entering mail id
	}
	
	
	//@SuppressWarnings("unlikely-arg-type")
	@Then("User can see error message")
	public void user_can_see_error_message() {
		String msg=driver.findElement(By.xpath(errorMsg_XPath)).getText();
		System.out.println(msg);
		if(msg==error_Msg1)
			System.out.println("Wrong Password");
		else if(msg==error_Msg2)
			System.out.println("Invalid Mailid or Phone number");
		else
			System.out.println("Unexcepted error occured");
			
		BeforeAfterClass.afterTest();
	}
	
	
	@Then("User verifies login credentials from a json file")
	public void user_verifies_login_credentials_from_a_json_file() throws InterruptedException, IOException, ParseException {
		utility.JsonDataRead.readJSON();
	}
	
}

