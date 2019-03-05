package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	/**
	 * Creates/opens Chrome WebDriver
	 * @return returns the driver
	 */
	public static WebDriver createDriver(){
		try{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			return driver;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null; 		
	}
	
	/**
	 * Wait method
	 * @param driver - WebDriver
	 * @param n - integer, in seconds
	 */
	public static void wait(WebDriver driver,int n){
		try{
			driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println(e);
		}		
	}
	
	/**
	 * Delay method
	 * @param n - integer, in seconds
	 */
	public static void delay(int n){
		try{
			TimeUnit.SECONDS.sleep(n);
		} catch (Exception e) {
			System.err.println(e);
		}		
	}
	
	/**
	 *  Enter username in the login form
	 * @param driver - WebDriver
	 * @param user - String
	 */
	public static void enterUsername(WebDriver driver, String user){
		try{
			driver.findElement(By.xpath("//input[@name = 'userName']")).sendKeys(user);
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * Enter password in the login form
	 * @param driver - WebDriver
	 * @param pass - String
	 */
	public static void enterPassword(WebDriver driver, String pass){
		try{
			driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(pass);
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * Click 'Sign-In' button after entering credentials to sign in
	 * @param driver - WebDriver
	 */
	public static void submitLogin(WebDriver driver){
		try{
			driver.findElement(By.xpath("//input[@name = 'submit']")).click();
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * Click 'Flights' from the left nav menu to go to the Flight Finder page
	 * @param driver - WebDriver
	 */
	public static void clickFlights(WebDriver driver){
		try{
			driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * On the Flight Finder page, click Continue to find flights
	 * @param driver - WebDriver
	 */
	public static void findFlights(WebDriver driver){
		try{
			driver.findElement(By.xpath("//input[@name = 'findFlights']")).click();
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	public static void selectFlightType(WebDriver driver){
		try{
			driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
			//driver.findElement(By.xpath("//input[@value='oneway']")).click();
		} catch(Exception e){
			System.err.println(e);
		}
	}
	/**
	 * Select the number of passengers on the Flight Finder page, integer value between 1-4
	 * @param driver - WebDriver
	 * @param n - integer
	 */
	public static void amtPassengers(WebDriver driver, int n){
		try{
			if(n>=1 && n<=4){
				driver.findElement(By.xpath("//select[@name='passCount']/option[@value='"+n+"']")).click();
			} else {
				System.out.println(n+" is out of bounds! Value must be 1-4");
			}			
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * Select a city for the 'Arriving In' drop down menu on the Flight Finder page
	 * @param driver - WebDriver
	 * @param city - String
	 */
	public static void selectArrivingIn(WebDriver driver, String city){
		try{
			driver.findElement(By.xpath("//select[@name='toPort']/option[@value='"+city+"']")).click();
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * Select a city from the 'Departing From' drop down menu on the Flight Finder page
	 * @param driver - WebDriver
	 * @param city - String
	 */
	public static void selectDepartingFrom(WebDriver driver, String city){
		try{
			driver.findElement(By.xpath("//select[@name='fromPort']/option[@value='"+city+"']")).click(); 
		} catch (Exception e){
			System.err.println(e);
		}
	}
	
	/**
	 * Select a 'Service Class' radio button on the Flight Finder page
	 * @param driver - WebDriver
	 */
	public static void selectServiceClass(WebDriver driver){
		try{
			driver.findElement(By.xpath("//input[@value = 'Coach']")).click(); //options: Coach, Business, First
		} catch (Exception e){
			System.err.println(e);
		}
	}
	
	
	
}
