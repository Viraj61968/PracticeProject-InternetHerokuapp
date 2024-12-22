package webElement;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappearing_Element {

	public static void main(String[] args) {
		
		/*
		 Validating the disappearance of an element in a web application is critical for ensuring proper functionality, user experience.
		 
		 Functionality 
		 1. Ensures Correct Functionality - Many web applications rely on dynamic content where elements appear or disappear based on user actions 
		 like the element should disappeared after it has completed the process i.e. as per the requirement.
		 
		 2. Confirms State Transitions - After submitting a form, the "Submit" button disappears, confirming the action was received by the server.
		 
		 3. Avoids UX Confusion - A modal dialog should disappear after the user clicks "Close." If it remains visible, 
		 						  users may think the action failed. 
		 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/disappearing_elements");
		
		//Validating if the element is visible or not after invoking the browser 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		int k = 0;
		for(int i = 0;i<2;i++) {
			System.out.println(k + "th loop");
			driver.navigate().refresh();
		try {
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Gallery")));
			System.out.println("Element is visible");
		}catch(Exception e)
		{
			System.out.println("Element is Disappeared");
		}
		k++;
		
		}
		
		driver.close();
		
	}

}
