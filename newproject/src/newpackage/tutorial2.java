package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tutorial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Driver.createDriver();
		
		//clickLink1(driver);
		clickLink2(driver);
		

	}
	
	/**
	 * Accessing links using Exact Text Match: By.linkText()
	 * Accessing links using their exact link text is done through the By.linkText() method. However, 
	 * if there are two links that have the very same link text, this method will only access the first one. 
	 * @param driver - WebDriver
	 */
	public static void clickLink1(WebDriver driver){
		String baseUrl = "http://demo.guru99.com/test/link.html";
		try{
			driver.get(baseUrl);
			driver.findElement(By.linkText("click here")).click();
			System.out.println("Title of page is: " + driver.getTitle());
			
			System.out.println("Test complete!");
		}catch(Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		} finally {
			driver.close();
		}
	}
	
	/**
	 * Accessing links using Partial Text Match: By.partialLinkText()
	 * Accessing links using a portion of their link text is done using the By.partialLinkText() method. 
	 * If you specify a partial link text that has multiple matches, only the first match will be accessed.
	 * @param driver - WebDriver
	 */
	public static void clickLink2(WebDriver driver){
		String baseUrl = "http://demo.guru99.com/test/accessing-link.html";
		try{
			driver.get(baseUrl);
			driver.findElement(By.partialLinkText("here")).click();
			System.out.println("Title of the page is: " + driver.getTitle());
			
			System.out.println("Test complete!");
		}catch(Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		}finally{
			driver.close();
		}
	}
	
	/**
	 * incomplete
	 * @param driver
	 *//*
	public static void clickLink3(WebDriver driver){
		String baseUrl = "";
		try{
			
		}catch(Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		}finally{
			driver.close();
		}
	}*/

}
