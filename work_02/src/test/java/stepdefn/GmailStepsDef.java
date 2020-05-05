package stepdefn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GmailStepsDef {

	
	WebDriver driver;
	
	String email="rohan.agarwal2";
	String pswd="";
	
	@Given("User is on Gmail login page")
	public void user_is_on_gmail_login_page()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin");
	}
	
	
	@When("User gets logged in to Gmail")
	public void user_gets_logged_in_to_Gmail() {
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	}

	@When("User opens a spefic mail")
	public void user_opens_a_spefic_mail() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Save the body message in a notepad file.")
	public void save_the_body_message_in_a_notepad_file() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
}
