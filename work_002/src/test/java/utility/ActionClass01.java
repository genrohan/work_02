package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ActionClass01 extends Path{
	
	WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using="Login")
	WebElement login_homePage;
	
	@FindBy(how = How.XPATH, using="(//input[@type='text'])[2]")
	WebElement mailfield;
	
	@FindBy(how = How.XPATH, using="(//input[@type='password'])")
	WebElement pswdfield;
	
	@FindBy(how = How.XPATH, using="(//input[@type='password'])")
	WebElement login;
	
	@FindBy(how = How.XPATH, using="//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement uname;
	
	@FindBy(how = How.XPATH, using="//html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")
	WebElement errorMsg;
	
	@FindBy(how = How.XPATH, using="//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div")
	static WebElement option;
	
	@FindBy(how = How.LINK_TEXT, using="Logout")
	static WebElement logout;
	
	public ActionClass01(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	
	public void enterDetails(String mail, String password) throws Exception {
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		System.out.println(mail);
		System.out.println(password);
		mailfield.sendKeys(mail);
		pswdfield.sendKeys(password);
		
	}
	
	public void loginClick() {
		login.click();
	}
	
	public void userVerify(String username) {
		try {
			assertEquals(uname.getText(), (username));
			System.out.println("Valid User : "+username);
			logout();
		}
		catch(Exception e) {
			String msg=errorMsg.getText();
			System.out.println(msg);
			System.out.println("Invalid User : "+username);
		}
	
	}
	
	
	public void errorMsg() {
		System.out.println(errorMsg.getText());
	}
	
	
	public void logout() {
		Actions actions = new Actions(driver);
		actions.moveToElement(option).perform();
		
		logout.click();
		login_homePage.click();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void readJSON()
	 {
	   
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader reader = new FileReader(json_path))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray employeeList = (JSONArray) obj;
	            System.out.println(employeeList);
	             
	            //Iterate over employee array
	            employeeList.forEach( emp -> {
					try {
						parseEmployeeObject( (JSONObject) emp );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    private void parseEmployeeObject(JSONObject employee) throws InterruptedException, Exception 
	    {
	        //Get employee object within list
	        JSONObject employeeObject = (JSONObject) employee.get("users");
	         
	        //Get employee first name
	        String email = (String) employeeObject.get("email");    
	        System.out.println(email);
	        
	        String uname = (String) employeeObject.get("username");    
	        System.out.println(uname);
	         
	        //Get employee last name
	        String pswd = (String) employeeObject.get("password");  
	        System.out.println(pswd);
	        
	        enterDetails(email,pswd);
	        loginClick();
	        userVerify(uname);
	        
			
			//BeforeAfterClass.afterTest();
			         
	    }
	
				
}
	
	

