package utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ActionClass02 {

	WebDriver driver;

	@FindBy(how = How.ID, using="twotabsearchtextbox")
	WebElement search_bar;
	
	@FindBy(how = How.CLASS_NAME, using="nav-search-submit")
	WebElement search_button;
	
	@FindBy(how = How.XPATH, using="(//div[@class='a-section a-spacing-none'])[7]")
	WebElement product01;
	
	@FindBy(how = How.XPATH, using="//span[@id='productTitle']")
	WebElement product_name;
	
	@FindBy(how = How.XPATH, using="//div[@id='feature-bullets']")
	WebElement product_details;
	
	@FindBy(how = How.XPATH, using="//div[@id='availability']/span")
	WebElement product_avail;
	
	String pName;
	String msg;
	String pDetails;
	String pAvai;
	
    String parentWinHandle;
    Set<String> winHandles;
	
	public ActionClass02(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

	public void productSearch(String product) {
		search_bar.sendKeys(product);
		search_button.click();
	}
	
	
	
	public void productDetails() {
		
		parentWinHandle = driver.getWindowHandle();	//storing parent window value
		
		product01.click();	//clicking on the product
		
	    winHandles = driver.getWindowHandles();
	    
	    //switching driver handle to the new window
		for(String handle: winHandles){
	            if(!handle.equals(parentWinHandle)){
	            driver.switchTo().window(handle);
	            }
		}
		
		pName = product_name.getText();						//getting product name
		System.out.println(pName);
	    pDetails = product_details.getText();	//getting product details
	    System.out.println(pDetails);
	    pAvai = product_avail.getText();	//getting product availability
	    System.out.println(pAvai);
	}
	
	public void writeNotepad() throws Exception {
		utility.txt_write.txt_write_notepad(pName,pAvai,pDetails);				//calling notepad write method   
	}
	
	public void writeExcel() throws Exception {
		utility.txt_write.txt_write_excel(pName,pAvai,pDetails);
	}
}
