package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptOnloadError {

	public static void main(String[] args) {
		
		/**
		 
		 A JavaScript Onload event error occurs when there's a failure during the execution of code that's meant to run when a page 
		 or resource finishes loading.
		 
		 when a JavaScript onload error occurs, it could be due to issues within specific elements (such as <img>, <iframe>, or <script>) 
		 that are involved in triggering the onload event.
		 
		 1. img - A missing or broken image will trigger JavaScript onload event error
		 2. iframe - The onload event for an iframe would typically trigger once the content within the iframe is fully loaded. 
		 			 If that content fails to load, the event handler may not be executed as expected.
		 3. script - If you are trying to load a JavaScript file via <script> and there's an error, such as the script file not being found or being blocked, 
		 			 the onload event for that <script> tag will fail.
		 
		*/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		try {
		driver.findElement(By.linkText("JavaScript onload event error")).click();
		
		//capturing Java-script console logs.
		
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
		
		/**
		 driver.manage().logs().get(LogType.BROWSER) tells selenium to get all the messages logged in the browser's console.
		 	1. Once DevTools opens, click on the Console tab. This is where all JavaScript-related logs are displayed, 
		 	   including errors, warnings, and informational messages.
		 	2. Errors are highlighted in red in the Console tab.
		*/
		for(org.openqa.selenium.logging.LogEntry log : logs) 
		{
			if(log.getLevel().toString().equalsIgnoreCase("SEVERE"))
		/**
		 1. Each log entry has a "level" (how important or critical it is).
		 2. SEVERE means there is a serious problem, like a JavaScript error.
		 3. This condition ensures only severe issues are handled (ignoring things like warnings). 
		 */
			{
				System.out.println(log.getMessage());
				//If the log is severe, it prints the message.
			}
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
