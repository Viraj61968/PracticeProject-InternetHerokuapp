package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_Remove_Element {

	public static void main(String[] args) {
		
		
		/*
		 Note - 
		 1. From a software testing perspective, adding or removing elements in a web browser is often tested to ensure that the application 
		 behaves correctly during dynamic DOM manipulation. This is especially important for web applications with dynamic content, 
		 such as SPAs (Single Page Applications), where elements are added, updated, or removed without a full page reload.
		 2. Functional Testing 
		 		a. Verify Functionality - Ensure the elements are correctly added or removed based on user actions
		 		b. Check UI Consistency - Validate the positioning, styling, and behavior of dynamically added elements. Ensure that removed 
		 								  elements no longer occupy space or affect layout.
		 		c. Error Handling - Ensure the application gracefully handles errors when an add/remove operation fails.
		 		d.Concurrency Testing - Simulate multiple users or rapid actions to test how the application handles concurrent add/remove 
		 								operations.
		 		e. Boundary Testing - Test adding elements to their maximum allowed number or size.
		 		f. Cross-Browser Testing - Test in multiple browsers to ensure consistent behavior.

		 */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		
		//Add Element 
		driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
		
		//Remove ELement
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='added-manually']"))).click();
		
		driver.close();
	}

}
