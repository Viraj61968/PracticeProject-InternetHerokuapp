package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_And_Drop {

	public static void main(String[] args) {
		
		/*
		 What is Drag and Drop Features 
		 	Drag and Drop is a common feature in modern web applications that allows users to move an element from 
		 	one location to another on the web page by clicking and holding the element (dragging) and 
		 	releasing it at the desired location (dropping).
		 
		 Why is Drag and Drop Functionality Tested?
		 	1. Ensure dropped items behave as expected e.g., updating data
		 	2. Tests ensure uniform behavior across all supported browsers.
		 	3. Validate that the application handles invalid drag-and-drop attempts gracefully. Ensure that elements dropped in the wrong location 
		 	   don’t cause unexpected behavior.
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		//Drag & Drop
		
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement target = driver.findElement(By.id("column-b"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		

	}

}
