package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_Authentication {

	public static void main(String[] args) {
		
		/*
		 Basic Authentication is commonly used in web applications to secure certain resources by requiring a username and password to access them.
		 
		 Purpose of Basic Authentication in Web Application 
		 
		 1. Temporary or Test Purpose - It is sometimes used for quick implementations or temporary authentication in testing environments, 
		 								such as APIs or web applications that don’t require heavy security mechanisms.
		 								
		 Also, the same syntax could also be applied for Digest Authentication.
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		
		//Basic Authentication 
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//Validating if it is successfully
		String Msg = driver.findElement(By.cssSelector(".example")).getText();
		Boolean result = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".example"), Msg));
		System.out.println(result);
		
		driver.close();
		
		
		
	}

}
