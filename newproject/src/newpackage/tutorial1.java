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
			driver.findElement(By.xpath("//input[@name = 'userName']")).sendKeys(user);
			driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(user);
			driver.findElement(By.xpath("//input[@name = 'submit']")).click();
			
			Driver.delay(3);
			driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
			
			driver.findElement(By.xpath("//input[@name = 'findFlights']")).click();
			//Driver.delay(driver, 10);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Driver.delay(3);
		} catch (Exception e){
			System.out.println("Something went wrong!");
			System.err.println(e);
		}
		
		driver.close();
	}
	
	
}
///html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]