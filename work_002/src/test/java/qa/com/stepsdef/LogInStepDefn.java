package qa.com.stepsdef;


import java.io.IOException;
//import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

//import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utility.*;

public class LogInStepDefn{


	WebDriver driver;
	ActionClass01 objLogin;// = new ActionClass(driver);
	BeforeAfterClass objSetup;// = new BeforeAfterClass(driver);

	@Given("User is on {string} HomePage")
	public void user_in_on_Flipkarts_Homepage(String url){
		objSetup = new BeforeAfterClass(driver);
		objSetup.startTest(url);
	}
	
	
	@When("User enters {string} and {string}")
	public void user_enters_details(String mail,String psswd) throws Exception  {
		objLogin = new ActionClass01(driver);
		/*List<List<String>> details = table.asLists();
		
		for(List<String> u : details) {
			objLogin.enterDetails(u.get(0).toString(),u.get(1).toString());
		}*/
		objLogin.enterDetails(mail,psswd);
		
	}
	
	@When("User clicks on final Login")
	public void user_clicks_on_final_login() throws Exception {
		objLogin = new ActionClass01(driver);
		objLogin.loginClick();
	}
	
	
	@Then("Verify {string} is logged in")
	public void verify_user_is_login(String username) throws Exception {
		objLogin = new ActionClass01(driver);
		/*List<List<String>> details = table.asLists();
		
		for(List<String> u : details) {
			objLogin.userVerify(u.get(0).toString()); 
		}*/
		objLogin.userVerify(username); 		
	}
		
	
	@When("User enters wrong {string} and {string}")
	public void user_enters_wrong_details( String mail, String psswd) throws Exception {
		objLogin = new ActionClass01(driver);
		
		/*List<List<String>> details = table.asLists();
		
		for(List<String> u : details) {
			objLogin.enterDetails(u.get(0).toString(),u.get(1).toString());
		}*/
		objLogin.enterDetails(mail,psswd);
	}
	
	
	@Then("User can see error message")
	public void user_can_see_error_message() {
		objLogin = new ActionClass01(driver);
		objLogin.errorMsg();
	}
	
	
	@Then("User verifies login credentials from a json file")
	public void user_verifies_login_credentials_from_a_json_file() throws InterruptedException, IOException, ParseException {
		objLogin.readJSON();
	}
	
}

