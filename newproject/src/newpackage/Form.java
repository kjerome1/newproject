package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Form {
	public static void main(String[] args){
		WebDriver driver = Driver.createDriver();
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

}
