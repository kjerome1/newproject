package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class tutorial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Driver.createDriver();
		
		//clickLink1(driver);
		//clickLink2(driver);
		//mouseEvents1(driver);
		//actionsEvent(driver);
		uploadFile(driver);
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
	 * How to get Multiple links with the same Link Text
	 * So, how to get around the above problem? In cases where there are multiple links with the same link text, 
	 * and we want to access the links other than the first one, how do we go about it?
	 * 
	 * In such cases, generally, different locators viz... By.xpath(), By.cssSelector() or By.tagName() are used.
	 * Most commonly used is By.xpath(). It is the most reliable one but it looks complex and non-readable too.
	 */
	
	/**
	 * Checks the background color before and after hovering the cursor over an element
	 * @param driver
	 */
	public static void mouseEvents1(WebDriver driver){
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		try{
			driver.get(baseUrl);
			WebElement link_Home = driver.findElement(By.linkText("Home"));
			WebElement td_Home = driver.findElement(By.xpath("//html/body/div"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr"));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.moveToElement(link_Home).build();
			
			String bgColor = td_Home.getCssValue("background-color");
			System.out.println("Before hover: "+bgColor);
			
			mouseOverHome.perform();
			bgColor = td_Home.getCssValue("background-color");
			System.out.println("After hover: "+bgColor);
			
		}catch(Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		}finally{
			driver.close();
		}
	}
	
	/**
	 * You can build a series of actions using the Action and Actions classes. 
	 * Just remember to close the series with the build() method
	 * @param driver
	 */
	public static void actionsEvent(WebDriver driver){
		String baseUrl = "http://www.facebook.com/";
		try{
			driver.get(baseUrl);
			WebElement txtUsername = driver.findElement(By.id("email"));
			
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder.moveToElement(txtUsername)
					.click()
					.keyDown(txtUsername, Keys.SHIFT)
					.sendKeys(txtUsername, "hello")
					.keyUp(txtUsername, Keys.SHIFT)
					.doubleClick(txtUsername)
					.contextClick()
					.build();
			
			seriesOfActions.perform();
		}catch(Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		}finally{
			driver.close();
		}
	}
	
	/**
	 * Upload test file to the test site 'http://demo.guru99.com/test/upload/'
	 * @param driver - WebDriver
	 */
	public static void uploadFile(WebDriver driver){
		String baseUrl = "http://demo.guru99.com/test/upload/";
		try{
			driver.get(baseUrl);
			WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
			
			//enter the file path onto the file-selection input field
			Driver.delay(3);
			uploadElement.sendKeys("C://Users/kjerome/Desktop/test.txt");
			
			//check the "I accept the terms of service" check box
			Driver.delay(3);
			driver.findElement(By.id("terms")).click();
			
			//click the "uploadFile" button
			Driver.delay(3);
			driver.findElement(By.name("send")).click();
			
			System.out.println("Upload file test complete.");			
		}catch(Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		}finally{
			driver.close();
		}
	}
	
	

}
