package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
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
	
	public static void wait(WebDriver driver,int n){
		try{
			driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public static void delay(int n){
		try{
			TimeUnit.SECONDS.sleep(n);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
}
