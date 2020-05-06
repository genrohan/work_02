package utility;

//import java.awt.Desktop.Action;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
//import java.io.Reader;
//import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.Path;

public class JsonDataRead extends Path {
	
	//static String path = "C:\Users\Agarwal\Desktop\BBDCUCUmberr\New folder\work_02\files\\data.json";
	 
	
	
	
	@SuppressWarnings("null")
	public static void login(String username, String password) throws InterruptedException, IOException {
		
		//WebDriver driver = null;
		System.out.println(username);
		System.out.println(password);
		driver.findElement(By.xpath(mailfield_XPath)).sendKeys(username);
		driver.findElement(By.xpath(pswdfield_XPath)).sendKeys(password);
		driver.findElement(By.xpath(login_XPath)).click();
		
		try {
			if(driver.findElements(By.xpath(uname_XPath)).size()>0)
			{
				//Actions actions = new Actions(driver);
				//WebElement button = driver.findElement(By.xpath(option_XPath));
				//actions.moveToElement(button).perform();
				
				//driver.findElement(By.linkText("Logout")).click();
				logout();
	
				System.out.println("Valid User");
			}
			/*else 
			{
				String msg=driver.findElement(By.xpath(errorMsg_XPath)).getText();
				System.out.println(msg);
				System.out.println("Invalid User");
			}*/
		}
		catch(Exception e) {
			String msg=driver.findElement(By.xpath(errorMsg_XPath)).getText();
			System.out.println(msg);
			System.out.println("Invalid User");
		}
	
	}
	
	
	public static void logout() {
		Actions actions = new Actions(driver);
		WebElement button = driver.findElement(By.xpath(option_XPath));
		actions.moveToElement(button).perform();
		
		driver.findElement(By.linkText("Logout")).click();
		
		   //clicking on signin button
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.findElement(By.linkText("Login")).click();
	}
	
		
	@SuppressWarnings("unchecked")
	public static void readJSON()
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
	 
	    private static void parseEmployeeObject(JSONObject employee) throws InterruptedException, Exception 
	    {
	        //Get employee object within list
	        JSONObject employeeObject = (JSONObject) employee.get("users");
	         
	        //Get employee first name
	        String uname = (String) employeeObject.get("username");    
	        System.out.println(uname);
	         
	        //Get employee last name
	        String pswd = (String) employeeObject.get("password");  
	        System.out.println(pswd);
	        
			login(uname,pswd);
			
			BeforeAfterClass.afterTest();
			         
	    }

}
	
	/*
	public static void readJSON() throws InterruptedException, IOException, ParseException {
		
		 JSONParser parser = new JSONParser();

	        try (Reader reader = new FileReader(path)) {

	            JSONObject jsonObject = (JSONObject) parser.parse(reader);
	            System.out.println(jsonObject);

	            String name = (String) jsonObject.get("username");
	            System.out.println(name);

	            long age = (Long) jsonObject.get("password");
	            System.out.println(age);

	            // loop array
	            JSONArray msg = (JSONArray) jsonObject.get("messages");
	            Iterator<String> iterator = msg.iterator();
	            while (iterator.hasNext()) {
	                System.out.println(iterator.next());
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	}*/
	


