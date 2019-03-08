package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Form {
	public static void main(String[] args){
		WebDriver driver = Driver.createDriver();
		
		//form1(driver);
		//form2(driver);
		accessDropDown(driver);
		
	}
	
	/**
	 * Created for Forms & WebDriver tutorial
	 * @param driver - WebDriver
	 */
	public static void form1(WebDriver driver){
		try{		
			String baseUrl = "http://demo.guru99.com/test/login.html";
			driver.get(baseUrl);
			
			//get element corresponding to the email field
			WebElement email = driver.findElement(By.id("email"));
			
			//get element corresponding to the password field
			WebElement password = driver.findElement(By.name("passwd"));
			
			email.sendKeys("abcd@gmail.com");
			password.sendKeys("abcdefghlkjl");
			System.out.println("Text fields set");
			Driver.delay(5);
			
			//deleting values in the text box
			email.clear();
			password.clear();
			System.out.println("Text fields cleared");
			Driver.delay(5);
			
			//find the submit button
			WebElement login = driver.findElement(By.id("SubmitLogin"));
			
			//using click method to submit form
			email.sendKeys("abcd@gmail.com");
			password.sendKeys("abcdefghlkjl");
			login.click();
			System.out.println("Login done with click()");
			Driver.delay(5);
			
			//using submit method to submit the form. Submit used on password field
			driver.get(baseUrl);
			driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
			driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
			driver.findElement(By.id("SubmitLogin")).submit();
			System.out.println("Login done with submit()");
			
			Driver.delay(5);
		} catch (Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		} finally {
			driver.close();
		}
	}
	
	/**
	 * Created for CheckBox & Radio Button tutorial
	 * @param driver - WebDriver
	 */
	public static void form2(WebDriver driver){
		try{
			driver.get("http://demo.guru99.com/test/radio.html");
			WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
			WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
			
			//radio button1 is selected
			radio1.click();
			System.out.println("Radio button option 1 is selected");
			
			//radio button 1 is de-selected and radio button2 is selected
			radio2.click();
			System.out.println("Radio button option 2 is selected");
			
			//selecting checkbox
			WebElement option1 = driver.findElement(By.id("vfb-6-0"));
			
			//this will toggle the check box
			option1.click();
			
			//check whether the check box is toggled on
			if(option1.isSelected()){
				System.out.println("Checkbox is toggled on");
			} else {
				System.out.println("Checkbox is toggled off");
			}
			
			//selecting checkbox and using isSelected method
			driver.get("http://demo.guru99.com/test/facebook.html");
			WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
			for(int i=0;i<2 ;i++){
				chkFBPersist.click();
				System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());
			}			
			
		} catch (Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		} finally {
			driver.close();
		}
	}
	
	/**
	 * Created for Selenium Webdriver DropDown tutorial
	 * @param driver - WebDriver
	 */
	public static void accessDropDown(WebDriver driver){
		String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		try{
			driver.get(baseUrl);
			Select drpCountry = new Select(driver.findElement(By.name("country")));
			drpCountry.selectByVisibleText("ANTARCTICA");
			
			//select items in a multiple select elements
			driver.get("http://jsbin.com/osebed/2");
			Select fruits = new Select(driver.findElement(By.id("fruits")));
			fruits.selectByVisibleText("Banana");
			fruits.selectByIndex(1);
			
			System.out.println("Access drop down test complete!");
			
		} catch (Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		} finally {
			driver.close();
		}
		
	}

}
