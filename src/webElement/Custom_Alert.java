package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Alert {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 Custom Alerts (Modal Dialogs)
		 				a. Warning Alerts: Highlight potential issues or risks (e.g., "Session is about to expire").
		 				b. Error Alerts: Indicate issues requiring user attention (e.g., "Invalid login credentials").
		 				c. Success Alerts: Confirm successful actions (e.g., "Data saved successfully").
		 				d. Actionable Alerts: Include buttons or actions for tasks (e.g., retry, upload files).
		 	
		 Definition - 
		 The functionality is similar to Alert from JavaScript but here the customize alerts are build from built using HTML, CSS, 
		 and JavaScript (often with libraries like Bootstrap, Material UI, or custom frameworks). 
		 These alerts are more flexible and visually appealing than native browser alerts.
		 
		 In short - The message displayed above the heading is a notification message. It is often used to convey information about an 
		 			action previously taken by the user.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
		
		//Just capturing the Text of the Alert to validate if it displayed or not.
		driver.findElement(By.linkText("Click here")).click();
		Thread.sleep(2000);
		String AlertText = driver.findElement(By.id("flash")).getText();
		System.out.println(AlertText);

	}

}
