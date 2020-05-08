package qa.com.stepsdef;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import utility.ActionClass02;
import utility.BeforeAfterClass;

public class PDPStepDef{

	WebDriver driver;
    
	BeforeAfterClass objSetup = new BeforeAfterClass(driver);
	ActionClass02 objAC2 = new ActionClass02(driver);
   
	String parentWinHandle;
    Set<String> winHandles;
	
	@Given("User is on {string} Home page")
	public void user_is_on_Amazon_Home_page(String url) throws Exception {
		//objSetup = new BeforeAfterClass(driver);
		objSetup.startTest(url);
	}

	@When("User search for {string}")
	public void user_search_for(String product) throws Exception {
		objAC2.productSearch(product);
	    Thread.sleep(3000);
	}
	
	
	@Given("User is on the product detail page")
	public void user_is_on_the_product_detail_page() throws Exception {
		
		 objAC2.productDetails();
	    
	}
	
	
	
	@Then("User stores data in a notepad file with path")
	public void user_store_data_in_a_notepad_file_with_path() throws Exception {
		objAC2.writeNotepad();				//calling notepad write method   
	}
	
	
	@Then("User stores data in a excel file with path")
	public void user_stores_data_in_a_excel_file_with_path() throws Exception {
		objAC2.writeExcel();
		driver.close();
	    driver.close();
	}

	
}
