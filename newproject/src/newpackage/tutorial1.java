package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tutorial1 {

	public static void main(String[] args){
		String url ="http://demo.guru99.com/test/newtours/index.php";
		String user = "tutorial";
		WebDriver driver = Driver.createDriver();
		driver.get(url);
		
		try{
			Driver.enterUsername(driver, user);
			Driver.enterPassword(driver, user);
			Driver.submitLogin(driver);
			
			Driver.delay(3);
			Driver.clickFlights(driver);
			Driver.selectFlightType(driver, "oneway");
			Driver.amtPassengers(driver, 2);
			Driver.selectDepartingFrom(driver, "London");
			Driver.departingDate(driver, 4, 1);
			Driver.selectArrivingIn(driver, "New York");
			Driver.arivalDate(driver, 4, 14);
			Driver.selectServiceClass(driver, "Business");
			Driver.selectAirline(driver, "Pangea Airlines");
			Driver.delay(10);
			Driver.findFlights(driver);
			
			System.out.println("Automation complete!");
		} catch (Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		} finally {
			driver.close();
		}
	}	
}