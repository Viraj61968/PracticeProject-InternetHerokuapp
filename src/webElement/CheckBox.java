package webElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		
		/*
		 What is Check Box ?
		 	A check box is a user interface (UI) element that allows users to make a binary choice between two states: 
		 	checked (selected) or unchecked (de-selected).
		 
		 When it is Used
		 	1. Form Submission - Agreeing Terms and Conditions.
		 	2. Selection - Selecting multiple - users.
		 	3. Settings and Preferences 
		 	4. Survey Questions
		 	
		 Functional Test 
		 	1. Single & Multiple Selection.
		 	2. Page Refresh Resilience.
		 	3. Form Submission with no selection.
		 	4. 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		
		//checked in the boxes
		List<WebElement>checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
		for(WebElement box : checkbox)
		{
			if(!box.isSelected()) {
				box.click();
			}
		}
		
		driver.close();

		
		
		
		
		
		
	}

}
