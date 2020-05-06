package stepdefn;

//import static org.hamcrest.MatcherAssert.*;
//import static org.hamcrest.Matchers.*;

import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import utility.BeforeAfterClass;
//import utility.txt_write;

public class PDPSteps extends BeforeAfterClass{

	//WebDriver driver;
    
	String product_name;
	String msg;
	String product_Details;
	String availability;
	
    String parentWinHandle;
    Set<String> winHandles;
    
	@Given("User is on {string} Home page")
	public void user_is_on_Amazon_Home_page(String url) throws Exception {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://www.amazon.in");			//opening the URL
		//Thread.sleep(3000);
		startTest(url);
	}

	@When("User search for {string}")
	public void user_search_for(String product) throws Exception {
	    driver.findElement(By.id(search_bar_id)).sendKeys(product); 	//writing product name on the search bar
	    driver.findElement(By.className(search_button_className)).click();			//clicking search button
	    Thread.sleep(3000);
	}
	
	
	@Given("User is on the product detail page")
	public void user_is_on_the_product_detail_page() throws Exception {
		
		parentWinHandle = driver.getWindowHandle();	//storing parent window value
		
		driver.findElement(By.xpath(product_XPath)).click();	//clicking on the product
	    Thread.sleep(3000);
	    
	    winHandles = driver.getWindowHandles();
	    
	    //switching driver handle to the new window
		for(String handle: winHandles){
	            if(!handle.equals(parentWinHandle)){
	            driver.switchTo().window(handle);
	            Thread.sleep(1000);
	            }
		}
		
		product_name = driver.findElement(By.xpath(product_name_XPath)).getText();						//getting product name
		System.out.println(product_name);
	    product_Details = driver.findElement(By.xpath(product_details_XPath)).getText();	//getting product details
	    System.out.println(product_Details);
	    availability = driver.findElement(By.xpath(product_avail_XPath)).getText();	//getting product availability
	    System.out.println(availability);
	    msg = "\n Availability " + availability + "\n Product Details : " + product_Details;
	    
	    
	}
	
	
	
	@Then("User stores data in a notepad file with path")
	public void user_store_data_in_a_notepad_file_with_path() throws Exception {
	    utility.txt_write.txt_write_notepad(product_name,availability,product_Details);				//calling notepad write method   
	}
	
	
	@Then("User stores data in a excel file with path")
	public void user_stores_data_in_a_excel_file_with_path() throws Exception {
		utility.txt_write.txt_write_excel(product_name,availability,product_Details);
		driver.close();
	    driver.close();
	}

	
}
