package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {
		
		/*
		 	Alerts are pop-up dialog boxes or notifications that capture the user’s attention to convey important information or require an action. 
		 	
		 	Types -
		 		1. Browser-Based Alerts
		 				a. Alert Box - Displays a simple message with an "OK" button (e.g., "Action completed successfully").
		 				b. Confirmation Box - Asks the user for confirmation with "OK" and "Cancel" buttons 
		 									  (e.g., "Are you sure you want to delete this record?").
		 				c. Prompt Box - Requests user input with a text field and buttons for confirmation or cancellation.
		 				
		 	Reason to Test -
		 	1. Performance - Check for performance bottlenecks when alerts are triggered.
		 	2. Test alert functionality across multiple browsers, devices, and screen sizes.
		 	3. Validate that alerts appear at the right time and in the right context i.e alerts do not disrupt workflow.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Alert Box.
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		driver.switchTo().alert().accept();
		String Result = driver.findElement(By.id("result")).getText();
		System.out.println(Result);
		
		System.out.println("--------");
		
		//Confirmation Box.
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		driver.switchTo().alert().accept();
		String Result1 = driver.findElement(By.id("result")).getText();
		System.out.println(Result1);
		
		System.out.println("--------");
		
		//Prompt Box.
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Prompt Alert");
		driver.switchTo().alert().accept();
		String Result2 = driver.findElement(By.id("result")).getText();
		System.out.println(Result2);

	}

}
