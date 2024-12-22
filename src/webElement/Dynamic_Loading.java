package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Loading {

	public static void main(String[] args) {
		
		/*
		 It's common to see an action get triggered that returns a result dynamically. It does not rely on the page to reload or finish loading. 
		 The page automatically gets updated (e.g. hiding elements, showing elements, updating copy, etc) through the use of JavaScript.
		 
		 Example - 
		 1. Form Validation - A "Submit" button gets enabled only when all inputs are valid.
		 2. Shopping Cart Updates - The cart icon updates with the new item count without refreshing the page
		 3. Filters on E-commerce Sites - The product grid updates immediately to display items matching the filters
		 4. Social Media Interactions - Clicking "Like" updates the like count immediately or Comments are posted dynamically without 
		 								refreshing the page.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//Element on page that is hidden or Element rendered after the fact.
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.tagName("button")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish"), "Hello World!"));
		
		
		

	}

}
