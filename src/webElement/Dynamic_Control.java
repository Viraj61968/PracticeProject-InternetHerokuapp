package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Control {

	public static void main(String[] args) {
		
		/*
		 Dynamic controls in a web application refer to elements on a webpage whose properties, behaviors, or 
		 visibility can change dynamically based on user interactions or programmatically triggered events. 
		 These controls add flexibility and interactivity to web applications by enabling content and UI updates without 
		 requiring a full page reload.
		 
		 Example - 
		 1. Show/Hide Controls - A "Read More" button that displays additional content when clicked.
		 2. Enable/Disable Controls - A text field that becomes editable based on user selection.
		 3. Dynamic Input Fields - Adding/removing rows in a form dynamically e.g., adding multiple phone numbers
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		
		//Remove the element 
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
		
		
		//Enable the Element 
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='text']"))).sendKeys("Text entered in the edit box");
		
		driver.close();

	}

}
