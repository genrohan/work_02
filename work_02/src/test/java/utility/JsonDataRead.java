package utility;

//import java.awt.Desktop.Action;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JsonDataRead {
	
	static String path = "e:\\\\data.json";
	 
	
	
	
	@SuppressWarnings("null")
	public static void login(String username, String password) throws InterruptedException {
		
		WebDriver driver = null;
		System.out.println(username);
		System.out.println(password);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys(password);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		if(driver.findElements(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).size()>0)
		{
			Actions actions = new Actions(driver);
			WebElement button = driver.findElement(By.xpath("//div[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div"));
			actions.moveToElement(button).perform();
			
			driver.findElement(By.xpath("//a[@href='/logout']")).click();

			System.out.println("Valid User");
		}
		else 
		{
			String msg=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")).getText();
			System.out.println(msg);
			System.out.println("Invalid User");
		}
	
		}
		
	@SuppressWarnings("unchecked")
	public static void readJSON()
	 {
	   
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader reader = new FileReader(path))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray employeeList = (JSONArray) obj;
	            System.out.println(employeeList);
	             
	            //Iterate over employee array
	            employeeList.forEach( emp -> {
					try {
						parseEmployeeObject( (JSONObject) emp );
					} catch (InterruptedException e) {
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
	 
	    private static void parseEmployeeObject(JSONObject employee) throws InterruptedException 
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
	


